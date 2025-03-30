package model.dao;


import java.util.List;

import model.dto.User;

public interface UserDao {
	
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
