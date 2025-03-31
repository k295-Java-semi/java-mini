package model.dao;


import model.dto.User;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import session.Session;

public interface UserDao {
	
	/**
	 * 회원가입
	 */
	int newRegister(User user) throws DMLException;
	
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
	int updateUser(Session session, User user) throws DMLException;
	
	/**
	 * 로그아웃 처리하는 메서드
	 */
	void logout(Session session);
	
	/**
	 * 회원 탈퇴
	 */
	int deleteUser(Session session) throws DMLException;
	
	/**
	 * 권한 확인
	 * role : guest(0), admin(1)
	 */
	boolean roleCheck(Session session) throws NotFoundException;
}