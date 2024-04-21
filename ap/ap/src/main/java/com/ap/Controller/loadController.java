package com.ap.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
public class loadController {

	@RequestMapping(value="/")
	public ModelAndView load()
	{
		return new ModelAndView("admin/index");
	}
}
