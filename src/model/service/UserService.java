package model.service;

import java.sql.SQLException;

import model.dto.User;
import pension.exception.NotFoundException;

public interface UserService {
    void register(User user) throws SQLException;
    User login(String email, String password) throws NotFoundException, SQLException;
    User getUserById(int userId) throws SQLException; 
    void updateUser(User user) throws SQLException; 
    void deleteUser(int userId) throws SQLException; 
    boolean checkEmailExists(String email) throws SQLException; 
    void changePassword(int userId, String newPassword) throws SQLException; 
}