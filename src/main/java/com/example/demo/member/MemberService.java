package com.example.demo.member;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.vo.MemberVo;

@Service
public class MemberService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private MemberMapper mapper; 

	
	public int getMemberCount(Map<String, Object> param) throws Exception {
		return mapper.getMemberCount(param);
	}
	
	public int addMember(Map<String, Object> param) throws Exception {
		return mapper.addMember(param);
	}
	
	public MemberVo getMember(Map<String, Object> param) throws Exception {
		return mapper.getMember(param);
	}
}
