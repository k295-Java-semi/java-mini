package model.dao;


import model.dto.User;

public interface UserDao {
    void insertUser(User user) throws Exception;
    User selectUserByEmail(String email) throws Exception;
    User selectUserById(int userId) throws Exception; // 추가
    void updateUser(User user) throws Exception; // 추가
    void deleteUser(int userId) throws Exception; // 추가
    boolean existsByEmail(String email) throws Exception; // 추가
    void updatePassword(int userId, String newPassword) throws Exception; // 추가
}