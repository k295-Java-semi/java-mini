package model.service;

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
