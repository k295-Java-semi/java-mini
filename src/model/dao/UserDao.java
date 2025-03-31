package model.dao;


import java.util.List;

import model.dto.User;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import session.Session;

public interface UserDao {
	
<<<<<<< HEAD
	// 모든 사용자 조회
	public List<User> findAllUsers();

    // 특정 사용자 조회
	public User findUserById(int id);

    // 사용자 추가
	public void addUser(User user);

    // 사용자 수정
	public void updateUser(User user);

    // 사용자 삭제
	public void deleteUser(int id);

}
=======
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
>>>>>>> develop
