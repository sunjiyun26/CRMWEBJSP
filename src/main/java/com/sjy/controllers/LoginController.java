package com.sjy.controllers;

import ch.qos.logback.classic.Logger;
import com.sjy.entities.User;
import com.sjy.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
	

	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
//
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.setValidator(new UserAuthValidate());
//	}
	
   /**
    * 登录路径
    * @return
    */
//	@RequestMapping("")
//	public String login() {
//		return "/home";
//	}
//
	@RequestMapping("/invalidSession")
	public String doubleLogin(){
		return "/invalidSession";
	}

	@RequestMapping(value = "/user/logon", method = RequestMethod.POST)
	public String login(@Validated User LoginUser, BindingResult result, HttpSession session, ModelMap map) {
		if (result.hasErrors()) {
			return "/login";
		}
		User user=userService.getByAccount(LoginUser.getAccount());
        if (null==user) {
			map.addAttribute("msg", "该账号不存在");
			return "/login";
		}
        if (!LoginUser.getPassword().equals(user.getPassword())) {
        	map.addAttribute("msg", "账号与密码不匹配");
        	return "/login";
		}
        session.setAttribute("user", user);
        LOGGER.info("user:{},登录了)",user.getUsername());
        return "redirect:/home";
	}
//	@RequestMapping("/login2")
//	public String Test(@SessionScope("currentUser") Employee employee){
//		if (employee==null||employee.getsId()==0) {
//			return "/login";
//		}else {
//			return "/index";
//		}
//	}

//	@ModelAttribute("user")
//	public User get() {
//		return new User();
//	}
}
