package model.service;

import model.dto.User;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import session.Session;

public interface UserService {
    
	/**
	 * 회원가입
	 */
	void newRegister(User user) throws DMLException;
	
	/**
	 * 로그인
	 */
	Session login(String email, String password) throws NotFoundException;
	
	/**
	 * 회원 정보 조회
	 */
	User userInfo(int userId) throws NotFoundException;
	
	/**
	 * 회원 정보 수정
	 */
	void updateUser(Session session, User user) throws DMLException;
	
	/**
	 * 로그아웃
	 */
	void logout(Session session);
	
	/**
	 * 회원 탈퇴
	 */
	void deleteUser(Session session) throws DMLException;
	
	/**
	 * 권한 확인
	 */
	boolean roleCheck(Session session) throws NotFoundException;
	
}
