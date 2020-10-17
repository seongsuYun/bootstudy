package com.example.demo.goods;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodsController {

	@RequestMapping("/goods/write")
	public String join(Model model, Map<String, Object> param) throws Exception {
		return "goods/write";
	}
	
	@RequestMapping("/goods/list")
	public String list(Model model, Map<String, Object> param) throws Exception {
		return "goods/list";
	}
	
	@RequestMapping("/goods/detail")
	public String detail(Model model, Map<String, Object> param) throws Exception {
		return "goods/detail";
	}	
	
}
