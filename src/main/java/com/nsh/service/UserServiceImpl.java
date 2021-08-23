package com.nsh.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsh.domain.UserVO;
import com.nsh.persistance.UserDAO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UserServiceImpl implements UserService {

	private final UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	//회원 가입 처리
	@Override
	public void register(UserVO userVo) throws Exception {
		log.info("비즈니스로 들어오나?");
		log.info("비즈니스가 받은 유저정보" + userVo.getUserId() + " " + userVo.getUserPw() + " " + userVo.getUserEmail() + " " + userVo.getUserName());
		userDAO.createUser(userVo);
		
	}

}
