package com.nsh.service;

import com.nsh.domain.UserVO;

public interface UserService {

	//회원 가입 처리(원래  더 명확한 메소드 이름을 사용해야 한다.)
	void register(UserVO userVo) throws Exception;
	
}
