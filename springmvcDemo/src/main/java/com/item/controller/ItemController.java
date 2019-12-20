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
	//ָ��·���ķ���url .action ��д�ɲ�д
	@RequestMapping(value = "/show")
	public ModelAndView itemList(){
		// ����ҳ����Ҫ��ʾ����Ʒ����
	    List<Items> list = new ArrayList<Items>();
	    list.add(new Items(1, "1��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�1"));	     
	    list.add(new Items(1, "1��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�2"));	     
	    list.add(new Items(1, "1��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�3"));	     
	    list.add(new Items(1, "1��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�4"));	     
	    list.add(new Items(1, "1��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�5"));
	    // ����ModelAndView����������ݺ���ͼ
	     ModelAndView mav = new ModelAndView();
	     // �������ݵ�ģ����
	     mav.addObject("itemList", list);
	     // ������ͼjsp ��Ҫ������ͼ�������ַ,Ĭ�Ϻ�׺��.jsp�Ļ���Ҫ���ú�׺sufix
	     mav.setViewName("itemList.jsp");	      
	     return mav;
	     }
	@RequestMapping(value = "/query")
	public ModelAndView query(){
		List list=itemDao.queryAll();
		ModelAndView mav = new ModelAndView();
	     // �������ݵ�ģ����
	     mav.addObject("itemList", list);
	     // ������ͼjsp ��Ҫ������ͼ�������ַ
	     mav.setViewName("itemList.jsp");	      
	     return mav;
	}
	@RequestMapping(value = "/{id}")
	public ModelAndView addItem(@PathVariable(value = "id") int id){
		ModelAndView mav = new ModelAndView();
		Items items=new Items(id, "1��Ϊ ��ҫ8", 2399f, new Date(), "�����ã�1");
		boolean bl=itemDao.addItems(items);
		 mav.setViewName("success.jsp");	      
	     return mav;
	}
	public void getContext(){
		//WebApplicationContextUtils.getWebApplicationContext(ServletContext);
	}
}
