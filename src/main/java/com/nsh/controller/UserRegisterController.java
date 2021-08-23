package com.nsh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nsh.domain.UserVO;
import com.nsh.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user/*")
@Log4j
public class UserRegisterController {

	private final UserService userService;
	
	@Autowired
	public UserRegisterController(UserService userService) {
		this.userService = userService;
	}
	
	//회원 가입 페이지
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGET() throws Exception {
		return "/user/register";
	}
	
	//회원 가입 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(UserVO userVO, RedirectAttributes rttr) throws Exception {
		log.info("들어오나?");
		log.info("유저정보" + userVO.getUserId() + " " + userVO.getUserPw() + " " + userVO.getUserEmail() + " " + userVO.getUserName());
		String hashedPW = BCrypt.hashpw(userVO.getUserPw(), BCrypt.gensalt());
		userVO.setUserPw(hashedPW);
		log.info("암호화 진행됐나?" + userVO.getUserPw());
		userService.register(userVO);
		rttr.addFlashAttribute("msg", "가입완료");		
		return "redirect:/user/login";
	}
}
