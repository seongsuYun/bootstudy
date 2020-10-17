package com.example.demo.member;

import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class MemberController {

	@RequestMapping("/join")
	public String join(Model model, Map<String, Object> param) throws Exception {
		return "member/join";
	}
	
	@RequestMapping("/login")
	public String login(Model model, Map<String, Object> param) throws Exception {
		return "member/login";
	}
}
