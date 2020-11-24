package com.example.demo.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.MemberMapper;
import com.example.demo.member.vo.MemberVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class MemberApiController {

	@Autowired
	private MemberMapper mapper;
	
	@ApiOperation(value = "회원정보조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "이메일", required = true, dataType = "string", paramType = "path"),
    })
	@GetMapping(value = "/member/{email}")
	public ResponseEntity<MemberVo> getMemberDetail(@PathVariable String email) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("email", email);
		
		MemberVo vo = mapper.getMember(param);
		
		return new ResponseEntity<MemberVo>(vo, HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원추가", notes = "API를 통해서 사용자를 추가할 수 있습니다.")
	@PostMapping(value = "/member")
	public ResponseEntity<Map<String, Object>> addMember(@RequestBody MemberVo vo) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("email", vo.getEmail());
			param.put("name", vo.getName());
			param.put("password", vo.getPassword());

			mapper.addMember(param);			
		} catch(Exception e) {
			returnMap.put("message", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Map<String,Object>>(returnMap, HttpStatus.OK);
	}
}
