package com.ssm.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.User;
import com.ssm.service.UserService;
  
  
@Controller    
public class UserController {  
	@Autowired
	private UserService userService;
    private static Logger LOGGER=LoggerFactory.getLogger(UserController.class);
      
    
    // /test?id=1
    //返回jsp页面
    @RequestMapping(value="/test",method=RequestMethod.GET)  
    //@ResponseBody
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
       
        LOGGER.info(user.toString());
        model.addAttribute("user", user);  
        return "success";  
    }  
    
    //返回jsp页面
    @RequestMapping(value="/queryById",method=RequestMethod.GET)  
    public ModelAndView queryById(HttpServletRequest request){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        System.out.println("userId:"+userId);
        User user=null;
        user = userService.queryById(userId);  
        ModelAndView mv = new ModelAndView();
        mv.setViewName("showUser");
        mv.addObject("user", user);
        return mv;  
    }
    //返回json数据
    @RequestMapping(value="/queryAll",method=RequestMethod.GET)  
    @ResponseBody
    public List<User> queryAll(){  
        List<User> users = userService.queryAll();  
        return users;
          
    }
//    @RequestMapping(value="/test",method=RequestMethod.GET)  
//    public String test(HttpServletRequest request,Model model){  
//        int userId = Integer.parseInt(request.getParameter("id"));  
//        System.out.println("userId:"+userId);
//        User user=null;
//        if (userId==1) {
//             user = new User();  
//             user.setAge(11);
//             user.setId(1);
//             user.setPassword("123");
//             user.setUserName("javen");
//        }
//       
//        LOGGER.info(user.toString());
//        model.addAttribute("user", user);  
//        return "success";  
//    } 
}
