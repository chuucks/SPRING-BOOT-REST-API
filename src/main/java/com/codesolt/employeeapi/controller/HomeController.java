package com.codesolt.employeeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class HomeController {

	 @GetMapping
     public ModelAndView  swaggerUi() {
         return new ModelAndView("redirect:" + "/swagger-ui.html");
     }	
}
