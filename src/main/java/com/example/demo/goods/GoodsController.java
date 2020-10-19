package com.example.demo.goods;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.member.vo.MemberVo;

@Controller
@SessionAttributes("USER_SESSION")
public class GoodsController {

	@Autowired
	private GoodsService service;
	
	@RequestMapping(value = "/goods/list", method = RequestMethod.GET)
	public String list(Model model, Map<String, Object> param, @ModelAttribute("USER_SESSION") MemberVo member) throws Exception {
		param.put("email", member.getEmail());
		
		model.addAttribute("list", service.getGoodsList(param));
		return "goods/list";
	}

	@RequestMapping(value = "/goods/detail", method = RequestMethod.GET)
	public String detail(Model model, Map<String, Object> param) throws Exception {
		return "goods/detail";
	}	
	
	@RequestMapping(value = "/goods/write", method = RequestMethod.GET)
	public String write(Model model, Map<String, Object> param) throws Exception {
		return "goods/write";
	}
	
	@RequestMapping(value = "/goods/write", method = RequestMethod.POST)
	public String writeProc(Model model, Map<String, Object> param) throws Exception {
		return "redirect:/goods/detail";
	}
	
}
