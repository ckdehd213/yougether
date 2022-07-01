package com.mysite.yougether.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserCreateForm {

	@Size(min = 6, max = 20)
	@NotEmpty(message = "사용자아이디는 필수항목입니다.")
	private String username;
	
	@NotEmpty(message = "비밀번호는 필수항목입니다.")
	private String password1;
	
	@NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
	private String password2;
	
	@Email
	@NotEmpty(message = "이메일은 필수항목입니다.")
	private String email;
}
