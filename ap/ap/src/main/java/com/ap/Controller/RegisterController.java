package com.ap.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ap.Model.LoginVO;
import com.ap.Model.RegisterVO;
import com.ap.Service.LoginService;
import com.ap.Service.RegisterService;
import com.ap.utils.Basemethods;

@Controller
public class RegisterController {
	@Autowired
	RegisterService registerservice;
	
	@Autowired
	LoginService loginservice;
	
	@GetMapping(value="/register")
	public ModelAndView register()
	{
		return new ModelAndView("register","RegisterVO",new RegisterVO());
	}
	
	@PostMapping(value="/registerStore")
	public ModelAndView registerStore(@ModelAttribute RegisterVO registervo)
	{

		LoginVO loginVO=registervo.getLoginVO();
		this.loginservice.insert(loginVO);
		
		registervo.setLoginVO(loginVO);
		this.registerservice.insertRegister(registervo);
		return new ModelAndView("login","LoginVO",new LoginVO());
	}
	
	@GetMapping(value="user/yourProfile")
	public ModelAndView yourProfile(@ModelAttribute RegisterVO registervo)
	{
		String user=Basemethods.getUser();
		List loginlist=this.loginservice.searchLoginId(user);
		LoginVO loginvo=(LoginVO)loginlist.get(0);
		
		registervo.setLoginVO(loginvo);
		List profilelist=this.registerservice.searchRegister(registervo);
		
		return new ModelAndView("user/manageProfile","profilelist",profilelist.get(0));
	}
	
	@PostMapping(value="user/updateRegister")
	public ModelAndView updateRegister(@ModelAttribute RegisterVO registervo,@RequestParam int registerId,@RequestParam int loginId)
	{
		//System.out.println("loginid="+loginId);
		LoginVO loginVO=registervo.getLoginVO();
		loginVO.setLoginId(loginId);
		this.loginservice.insert(loginVO);
		
		registervo.setLoginVO(loginVO);
		registervo.setRegisterId(registerId);
		this.registerservice.insertRegister(registervo);
		return new ModelAndView("user/index");
	}
	

}
