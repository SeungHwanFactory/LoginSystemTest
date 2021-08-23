package com.nsh.persistance;

import com.nsh.domain.UserVO;

public interface UserDAO {

	//회원가입
	void createUser(UserVO userVO) throws Exception;
}
