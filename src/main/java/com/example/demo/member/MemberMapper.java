package com.example.demo.member;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.member.vo.MemberVo;

@Mapper
public interface MemberMapper {

	public int getMemberCount(Map<String, Object> param) throws SQLException;
	
	public int addMember(Map<String, Object> param) throws SQLException;
	
	public MemberVo getMember(Map<String, Object> param) throws SQLException;
}
