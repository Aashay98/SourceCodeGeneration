package com.ap.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ap.Model.FeedbackVO;
import com.ap.Model.LoginVO;
import com.ap.Service.FeedbackService;
import com.ap.Service.LoginService;
import com.ap.utils.Basemethods;

@Controller
public class FeedbackController {
	@Autowired
	FeedbackService feedbackservice;

	@Autowired
	LoginService loginservice;

	@GetMapping(value="user/feedbackForm")
	public ModelAndView userFeedbackForm()
	{
		return new ModelAndView("user/addFeedback","FeedbackVO",new FeedbackVO());
	}

	@PostMapping(value="user/saveUserFeedback")
	public ModelAndView saveUserFeedback(@ModelAttribute FeedbackVO feedbackvo)
	{
		System.out.println("in controller");
		String user=Basemethods.getUser();
		List loginlist=this.loginservice.searchLoginId(user);
		LoginVO loginvo=(LoginVO)loginlist.get(0);
		
		feedbackvo.setLoginvo(loginvo);
		
		this.feedbackservice.insertUserFeedback(feedbackvo);
		return new ModelAndView("redirect:/user/feedbackForm");
	}
	
	@GetMapping(value="user/viewUserFeedback")
	public ModelAndView viewUserFeedback(@ModelAttribute FeedbackVO feedbackvo)
	{
		String user=Basemethods.getUser();
		List loginlist=this.loginservice.searchLoginId(user);
		LoginVO loginvo=(LoginVO)loginlist.get(0);
		
		feedbackvo.setLoginvo(loginvo);
		
		List feedbacklist=this.feedbackservice.searchUserFeedback(feedbackvo);
		return new ModelAndView("user/viewFeedback","feedbacklist",feedbacklist);
	}
	
	@GetMapping(value="user/deleteUserFeedback")
	public ModelAndView deleteUserFeedback(@ModelAttribute FeedbackVO feedbackvo,@RequestParam int id)
	{
		
		feedbackvo.setId(id);
		List deletefeedbacklist=this.feedbackservice.deleteUserFeedback(feedbackvo);
		
		feedbackvo=(FeedbackVO)deletefeedbacklist.get(0);
		feedbackvo.setStatus(false);
		
		this.feedbackservice.insertUserFeedback(feedbackvo);
		
		return new ModelAndView("redirect:/user/viewUserFeedback");
	}
	
	@GetMapping(value="user/updateUserFeedback")
	public ModelAndView editUserFeedback(@ModelAttribute FeedbackVO feedbackvo,@RequestParam int id)
	{
		
		feedbackvo.setId(id);
		List updatefeedbacklist=this.feedbackservice.deleteUserFeedback(feedbackvo);
		
		return new ModelAndView("user/addFeedback","FeedbackVO",updatefeedbacklist.get(0));
	}
	
	@GetMapping(value="admin/viewAdminFeedback")
	public ModelAndView viewAdminFeedback(@ModelAttribute FeedbackVO feedbackvo)
	{	
		List feedbacklist=this.feedbackservice.searchAdminFeedback();
		return new ModelAndView("admin/viewFeedback","feedbacklist",feedbacklist);
	}
	
	@GetMapping(value="admin/deleteAdminFeedback")
	public ModelAndView deleteAdminFeedback(@ModelAttribute FeedbackVO feedbackvo,@RequestParam int id)
	{
		
		feedbackvo.setId(id);
		List deletefeedbacklist=this.feedbackservice.deleteUserFeedback(feedbackvo);
		
		feedbackvo=(FeedbackVO)deletefeedbacklist.get(0);
		feedbackvo.setStatus(false);
		
		this.feedbackservice.insertUserFeedback(feedbackvo);
		
		return new ModelAndView("redirect:/admin/viewAdminFeedback");
	}
	
}
