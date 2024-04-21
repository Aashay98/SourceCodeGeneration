package com.ap.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ap.Model.ComplainVO;
import com.ap.Model.FeedbackVO;
import com.ap.Model.LoginVO;
import com.ap.Model.ProjectVO;
import com.ap.Service.LoginService;
import com.ap.Service.ProjectService;
import com.ap.utils.Basemethods;

@Controller
public class ProjectController {
	@Autowired
	LoginService loginservice;
	
	@Autowired
	ProjectService projectservice;
	
	@GetMapping(value="user/viewUserProject")
	public ModelAndView viewUserProject(@ModelAttribute ProjectVO projectvo)
	{
		String user=Basemethods.getUser();
		List loginlist=this.loginservice.searchLoginId(user);
		LoginVO loginvo=(LoginVO)loginlist.get(0);
		
		projectvo.setLoginvo(loginvo);
		List projectlist=this.projectservice.searchProject(projectvo);
		
		return new ModelAndView("user/viewProject","projectlist",projectlist);
	}
	
	@GetMapping(value="user/deleteUserProject")
	public ModelAndView deleteUserProject(@ModelAttribute ProjectVO projectvo,@RequestParam int projectId)
	{
		projectvo.setProjectId(projectId);
		List deletelist=this.projectservice.searchUserdeleteProject(projectvo);
		System.out.println(deletelist.get(0));
	
		projectvo=(ProjectVO)deletelist.get(0);
		projectvo.setStatus(false);
		this.projectservice.deleteProject(projectvo);
		
		return new ModelAndView("redirect:/user/viewUserProject");
	}
	
	@GetMapping(value="admin/viewAdminProject")
	public ModelAndView viewAdminProject(@ModelAttribute ProjectVO projectvo)
	{	
		List projectlist=this.projectservice.searchAdminProject(projectvo);
		return new ModelAndView("admin/viewProject","projectlist",projectlist);
	}

}
