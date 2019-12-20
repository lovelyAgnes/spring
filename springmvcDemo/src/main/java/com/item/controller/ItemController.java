package com.item.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.item.dao.ItemDao;
import com.item.pojo.Items;

@Controller
public class ItemController {
	@Autowired
	private ItemDao itemDao;
	//指定路径的访问url .action 可写可不写
	@RequestMapping(value = "/show")
	public ModelAndView itemList(){
		// 创建页面需要显示的商品数据
	    List<Items> list = new ArrayList<Items>();
	    list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));	     
	    list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！2"));	     
	    list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！3"));	     
	    list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！4"));	     
	    list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！5"));
	    // 创建ModelAndView用来存放数据和视图
	     ModelAndView mav = new ModelAndView();
	     // 设置数据到模型中
	     mav.addObject("itemList", list);
	     // 设置视图jsp 需要设置视图的物理地址,默认后缀是.jsp的话需要配置后缀sufix
	     mav.setViewName("itemList.jsp");	      
	     return mav;
	     }
	@RequestMapping(value = "/query")
	public ModelAndView query(){
		List list=itemDao.queryAll();
		ModelAndView mav = new ModelAndView();
	     // 设置数据到模型中
	     mav.addObject("itemList", list);
	     // 设置视图jsp 需要设置视图的物理地址
	     mav.setViewName("itemList.jsp");	      
	     return mav;
	}
	@RequestMapping(value = "/{id}")
	public ModelAndView addItem(@PathVariable(value = "id") int id){
		ModelAndView mav = new ModelAndView();
		Items items=new Items(id, "1华为 荣耀8", 2399f, new Date(), "质量好！1");
		boolean bl=itemDao.addItems(items);
		 mav.setViewName("success.jsp");	      
	     return mav;
	}
	public void getContext(){
		//WebApplicationContextUtils.getWebApplicationContext(ServletContext);
	}
}
