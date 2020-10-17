package com.example.demo;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(Model model, Map<String, Object> param) throws Exception {
		log.debug(" 지금부터 로그 시작============");
		log.debug(" 지금부터 로그 시작============");
		log.debug(" 지금부터 로그 시작============");
		return "index";
	}
	
}
