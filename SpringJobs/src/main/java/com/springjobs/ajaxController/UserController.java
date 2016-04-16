package com.springjobs.ajaxController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springjobs.domain.User;
import com.springjobs.service.user.UserService;

@Controller
public class UserController {
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@RequestMapping( value="/user1", method=RequestMethod.POST)
	public void getJsonUser1(	@RequestBody User user, 
									 			Model model) throws Exception{
		System.out.println("/getJsonUser2 : POST value : "+user);
		model.addAttribute("user", user);
	}
	
	@RequestMapping( value="/user2", method=RequestMethod.GET)
	public void getJsonUser2(	@RequestParam("userId") String userId, 
			Model model) throws Exception{
		System.out.println("/getJsonUser2 : GET value : "+userId);
		User user = new User(0, "cobb","Haha", "1234");
		model.addAttribute("user", user);
	}
	
	@RequestMapping( value="/addUser", method=RequestMethod.POST)
	public void addUser(@RequestBody User user){
		System.out.println("addUser called"+user.getUem());
		userService.addUser(user);
	}
	
	@RequestMapping( value="/login", method=RequestMethod.POST)
	public void login(@RequestBody User user, Model model){
		System.out.println("Login Request : "+user.getUem());
		model.addAttribute("loginResult", userService.login(user));
	}
	
	@RequestMapping( value="/idDuplicateCheck", method=RequestMethod.POST)
	public void idDuplicateCheck(@RequestBody User user, Model model){
		System.out.println("idDuplicateCheck Request : "+user.getUem());
		model.addAttribute("duplicateResult", userService.idDuplicateCheck(user));
	}
}