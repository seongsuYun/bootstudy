package com.example.demo.member;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MemberController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model, Map<String, Object> param) throws Exception {
		return "member/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> joinProc(Model model, Map<String, Object> param) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultCode", Boolean.TRUE);
		
		service.addMember(param);
		
		return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login")
	public String login(Model model, Map<String, Object> param) throws Exception {
		return "member/login";
	}
}
