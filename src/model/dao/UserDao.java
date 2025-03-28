package model.dao;


import model.dto.User;
import pension.exception.DMLException;
import pension.exception.NotFoundException;

public interface UserDao {
	
	/**
	 * 회원가입
	 */
	int newRegister(User user) throws DMLException;
	
	/**
	 * 로그인
	 */
	
	
	/**
	 * 회원 정보 수정
	 */
	int updateUser(User user) throws DMLException;
	
	/**
	 * 회원 탈퇴
	 */
	int deleteUser(int userId) throws DMLException;
	
	/**
	 * 권한 확인
	 * role : guest(0), admin(1)
	 */
	boolean roleCheck(int userId) throws NotFoundException;
}