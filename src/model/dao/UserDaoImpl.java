package model.dao;

import model.dto.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAllUsers() {
        return List.of();
    }

    @Override
    public User findUserById(int id) {

        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
