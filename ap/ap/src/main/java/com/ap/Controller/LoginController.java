package com.ap.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ap.Model.LoginVO;
import com.ap.Service.LoginService;
import com.ap.utils.Basemethods;

@Controller
public class LoginController {

	@Autowired LoginService loginservice;

	@GetMapping(value = "/")
	public ModelAndView loadLogin() {
		System.out.println("controller");
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex() {

		/*User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();*/
		
		return new ModelAndView("admin/index");
	}
	
	@RequestMapping(value = "/user/index", method =RequestMethod.GET)
	public ModelAndView userIndex() {

		return new ModelAndView("user/index");
	}
	
	@RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})	
	public String viewUserDetails(ModelMap model,HttpServletResponse response,HttpServletRequest request) {

		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            request.getSession().invalidate();
	            request.getSession().setAttribute("tempStatus", "success");
	            request.getSession().setAttribute("statusText", "Logout Successfully!");
	        }
	        return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {

		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error() {

		return new ModelAndView("login");
	}
	
	@GetMapping(value = "/changepassword")
	public ModelAndView changePassword() {
		
		return new ModelAndView("/changePassword","LoginVO",new LoginVO());
	}
	
	@PostMapping(value = "/checkpassword")
	public ModelAndView checkPassword(HttpServletRequest request,HttpServletResponse response,HttpSession session,@ModelAttribute LoginVO loginvo) {
		String oldPassword=loginvo.getPassword();
		System.out.println("op="+oldPassword);
		
		String user=Basemethods.getUser();
		List loginlist=this.loginservice.searchLoginId(user);
		loginvo=(LoginVO)loginlist.get(0);
		String searchpassword=loginvo.getPassword();	
		System.out.println("db="+searchpassword);
		
		String newPassword=request.getParameter("newpassword");
		System.out.println("np="+newPassword);
		
		String confirmPassword=request.getParameter("confirmpassword");
		System.out.println("cnp="+confirmPassword);		
		
		if(oldPassword.equals(searchpassword))
		{	
			if(newPassword.equals(confirmPassword))
			{
				loginvo.setPassword(confirmPassword);
				this.loginservice.updatePassword(loginvo);
				return new ModelAndView("/login");
			}
			else
			{	
				
				return new ModelAndView("redirect:/changepassword");
			}
		}	
		else
		{
			session.setAttribute("erroroldpassword", "write the correct old password");
			return new ModelAndView("redirect:/changepassword");
		}	
	}
	
	@GetMapping(value="/forgetPassword")
	public ModelAndView forgetPassword() {
		
		return new ModelAndView("/forgotPassword","LoginVO",new LoginVO());
	}
	
	@PostMapping(value="/addusernamefp")
	public ModelAndView addusernamefp(HttpSession session,@ModelAttribute LoginVO loginvo) {
		
		String userName=loginvo.getUsername();
		
		session.setAttribute("username", userName);
		List loginlist=this.loginservice.searchLoginId(userName);
		
		if(loginlist!=null && !loginlist.isEmpty())
		{
			String otp=Basemethods.generatePassword();
			session.setAttribute("otpsave", otp);
			Basemethods.sendMail(userName, otp);
			return new ModelAndView("/otpverify");
		}	
		else
		{
			return new ModelAndView("redirect:/forgetpassword");
		}
	}
	
	@PostMapping(value="/otpcheck")
	public ModelAndView otpverify(HttpSession session,@RequestParam String otpcheck) {
		
		System.out.println(otpcheck);
		String otpsave=(String)session.getAttribute("otpsave");
		if(otpsave.equals(otpcheck))
		{
			return new ModelAndView("/createNewPassword");
		}
		else
		{
			session.setAttribute("errorotp", "write the correct otp");
			return new ModelAndView("/otpverify");
		}
		
	}
	
	@PostMapping(value="/createnewpassword")
	public ModelAndView createnewpassword(@ModelAttribute LoginVO loginvo,HttpSession session,@RequestParam String newpassword,String confirmpassword) {
		
		String user=(String)session.getAttribute("username");
		System.out.println("User="+user);
		loginvo.setUsername(user);
		
		List loginlist=this.loginservice.searchLoginId(user);
		loginvo=(LoginVO)loginlist.get(0);
		
		
		if(newpassword.equals(confirmpassword))
		{
			loginvo.setPassword(confirmpassword);
			this.loginservice.updatePassword(loginvo);
			return new ModelAndView("/login");
		}
		else
		{
			
			return new ModelAndView("/createNewPassword");
		}
		
	}
	
}