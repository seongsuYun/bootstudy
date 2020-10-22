package com.example.demo.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.member.vo.MemberVo;

public class SessionUtil {

	private static final String SESSION_USER = "USER_SESSION";
	
	public static MemberVo getUser() {
		try {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			return (MemberVo)request.getSession().getAttribute(SESSION_USER);
		} catch(Exception e) {
			return null;
		}
	}
	
}
