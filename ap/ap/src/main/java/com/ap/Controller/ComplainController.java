package com.ap.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ap.Model.ComplainVO;
import com.ap.Model.LoginVO;
import com.ap.Service.ComplainService;
import com.ap.Service.LoginService;
import com.ap.utils.Basemethods;

@Controller
public class ComplainController {
	
	@Autowired
	ComplainService complainservice;
	
	@Autowired
	LoginService loginservice;

	@GetMapping(value="user/loadComplain")
	public ModelAndView loadComplain()
	{
		return new ModelAndView("user/addComplain","ComplainVO",new ComplainVO()); 
	}
	
	@PostMapping(value="user/complainInsert")
	public ModelAndView insertComplain(@ModelAttribute ComplainVO complainvo,@RequestParam(name="file") MultipartFile file,HttpSession session)
	{
		String user=Basemethods.getUser();
		List loginlist=this.loginservice.searchLoginId(user);
		LoginVO loginvo=(LoginVO)loginlist.get(0);
		
		String path=session.getServletContext().getRealPath("/"); // this path is up until webapp
		String filePath=path+"document/complain/";
		String fileName = file.getOriginalFilename();
		
		try
		{
			byte b[] = file.getBytes();		
			BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(new FileOutputStream(filePath+fileName));
			bufferedOutputStream.write(b);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Date dt=new Date();
		DateFormat dateformat=new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		
		String complainStatus="pending";
		
		complainvo.setLoginvo(loginvo);
		complainvo.setComplainTime(dateformat.format(dt));
		complainvo.setComplainStatus(complainStatus);
		complainvo.setFilePath(filePath);
		complainvo.setFilepathName(fileName);
		this.complainservice.insertComplain(complainvo);
		
		return new ModelAndView("redirect:/user/loadComplain"); 
	}
	@GetMapping(value="user/complainView")
	public ModelAndView viewUserComplain(@ModelAttribute ComplainVO complainvo)
	{
		String user=Basemethods.getUser();
		List loginlist=this.loginservice.searchLoginId(user);
		LoginVO loginvo=(LoginVO)loginlist.get(0);
		
		complainvo.setLoginvo(loginvo);
		List complainlist=this.complainservice.userViewComplain(complainvo);
		
		for(int i=0;i<complainlist.size();i++)
		{
			complainvo = (ComplainVO)complainlist.get(i);
			System.out.println("List "+i+" ="+complainvo.getComplainDescription()+" "+complainvo.getComplainSubject());		
		}
		
		System.out.println(complainlist.size());
		return new ModelAndView("user/viewReply","complainlist",complainlist); 
	}
	
	@GetMapping(value="admin/adminViewComplain")
	public ModelAndView viewAdminComplain()
	{
		List admincomplainlist=this.complainservice.adminViewComplain();
		return new ModelAndView("admin/viewComplain","admincomplainlist",admincomplainlist);
	}
	
	@GetMapping(value="admin/reply")
	public ModelAndView adminLoadReply(@ModelAttribute ComplainVO complainvo,@RequestParam int id)
	{
		System.out.println("id="+id);
		complainvo.setId(id);
		List loadreply=this.complainservice.adminReply(complainvo);
		return new ModelAndView("admin/Reply","loadreply",loadreply.get(0));
	}
	
	@PostMapping(value="admin/saveReply")
	public ModelAndView adminSaveReply(@ModelAttribute ComplainVO complainvo,@RequestParam int id)
	{
		System.out.println("id="+id);
		complainvo.setId(id);
		
		String complainStatus="Resolved";
		complainvo.setComplainStatus(complainStatus);
		
		Date dt=new Date();
		DateFormat dateformat=new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		complainvo.setReplyTime(dateformat.format(dt));

		this.complainservice.insertComplain(complainvo);
		return new ModelAndView("redirect:/admin/adminViewComplain");
	}
	
	@GetMapping(value="user/deleteUserComplain")
	public ModelAndView deleteUserComplain(@ModelAttribute ComplainVO complainvo,@RequestParam int id)
	{
		complainvo.setId(id);
		List deletelist=this.complainservice.deleteUserReply(complainvo);
		System.out.println(deletelist.get(0));
	
		complainvo=(ComplainVO)deletelist.get(0);
		complainvo.setStatus(false);
		this.complainservice.insertComplain(complainvo);
		
		return new ModelAndView("redirect:/user/complainView");
	}
}
