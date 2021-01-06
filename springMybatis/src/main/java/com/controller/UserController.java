package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.service.IUserService;
import com.service.UserServiceImpl;

@Controller  
@RequestMapping("/user") 
public class UserController {
private static Logger log=LoggerFactory.getLogger(UserController.class);

 //IUserService userService=new UserServiceImpl();
	@Autowired
    private IUserService userService;
    //http://localhost:8088/springMybatis/user/showUser?id=1
    // /user/test?id=1
    @RequestMapping(value="/test",method=RequestMethod.GET)  
    public String test(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        System.out.println("userId:"+userId);
        User user=null;
        if (userId==1) {
             user = new User();  
             user.setAge(11);
             user.setId(1);
             user.setPassword("123");
             user.setUserName("javen");
        }
       
        log.info(user.toString());
        model.addAttribute("user", user);  
        return "index";  
    }
    
 // /user/showUser?id=1
    @RequestMapping(value="/showUser",method=RequestMethod.GET)  
    public String showUser(HttpServletRequest request,HttpSession session){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        System.out.println("userId:"+userId);
        User user = null;
        user = userService.getUserById(userId);  
        log.info("showUser:"+user.toString());
        //log.debug(user.toString());
//        model.addAttribute("user", user);  
        session.setAttribute("user", user);
        User user2 =(User) session.getAttribute("user");
        System.out.println(user2.getUserName());
        return "showUser";  
    }  
    @RequestMapping(value="ddd",method= RequestMethod.GET)
    public String test(HttpServletRequest request){
    	log.info("test:监控数据收集");
    	return "list";
    	
    }
    
    
}
