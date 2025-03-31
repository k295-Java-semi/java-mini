package model.service;

<<<<<<< HEAD
import java.util.List;

import model.dto.User;
import pension.exception.AddException;
import pension.exception.DeleteException;
import pension.exception.FindException;
import pension.exception.ModifyException;

public interface UserService {
	// 모든 사용자 조회
	List<User> getAllUsers() throws FindException;

	// 특정 사용자 조회
	User getUser(int userNo) throws FindException;

	// 사용자 추가
	void addUser(User user) throws AddException;

	// 사용자 정보 수정
	void modifyUser(User user) throws ModifyException;

	// 사용자 삭제
	void removeUser(int userNo) throws DeleteException;

}
=======
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
>>>>>>> develop
