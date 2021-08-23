package com.nsh.persistance;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.nsh.domain.UserVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserDAOImpl  implements UserDAO {

	//메모리에 올리고 변하지 않게 클래스 내부에서 공유
	private static final String NAMESPACE = "com.nsh.loginsystem.mappers.user.UserMapper";
	
	private final SqlSession sqlSession;
	
	//생성자 주입
	@Autowired
	public UserDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//회원 가입 처리
	@Override
	public void createUser(UserVO userVO) throws Exception {
		log.info("영속으로 들어오나?");
		sqlSession.insert(NAMESPACE + ".createUser", userVO);
		
	}

}
