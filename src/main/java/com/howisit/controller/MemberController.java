package com.howisit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	//문의하기
	@GetMapping(value = "/members/qa")
	public String qa() {
		return "member/qa";
	}
	
	//로그인 화면
	@GetMapping(value = "/members/Login")
	public String loginMember() {
		return "member/memberLoginForm";
	}
	
	//회원가입화면
	@GetMapping(value = "/members/new")
	public String memberForm() {
		return "member/memberForm";
	}
}
