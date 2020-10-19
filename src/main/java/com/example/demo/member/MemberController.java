package com.example.demo.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.member.vo.MemberVo;

@Controller
@SessionAttributes("USER_SESSION")
public class MemberController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model, @RequestParam Map<String, String> param) throws Exception {
		return "member/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> joinProc(Model model, @RequestParam Map<String, Object> param) throws Exception {
		service.addMember(param);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultCode", Boolean.TRUE);
		resultMap.put("resultMessage", "가입완료");
		
		return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login")
	public String login(Model model, @RequestParam Map<String, Object> param) throws Exception {
		return "member/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginProc(Model model, @RequestParam Map<String, Object> param, HttpServletRequest request) throws Exception {
		MemberVo vo = service.getMember(param);
		if(vo == null) {
			return "member/login";
		}
		
		String password = (String)param.get("password");
		if(vo.getPassword().equals(password)) {
			model.addAttribute("USER_SESSION", vo);
		}

		return "redirect:/goods/list";
	}
	
	@RequestMapping(value = "/logout")
	public String login(Model model, HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		return "member/login";
	}
}
