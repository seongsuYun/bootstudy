package com.example.demo.member.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberVo {
	@ApiModelProperty(required = true, name = "email", value = "이메일")
	private String email; 
	@ApiModelProperty(required = true, name = "name", value = "이름")
	private String name;
	@ApiModelProperty(required = true, name = "password", value = "패스워드")
	private String password;
	@ApiModelProperty(required = false, name = "enterDate", value = "등록일자")
	private String enterDate;
}
