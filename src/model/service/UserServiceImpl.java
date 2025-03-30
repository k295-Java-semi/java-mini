package model.service;

import java.util.List;

import model.dao.UserDao;
import model.dto.User;
import pension.exception.AddException;
import pension.exception.DeleteException;
import pension.exception.FindException;
import pension.exception.ModifyException;

public abstract class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) throws AddException {
		userDao.addUser(user);
	}

	@Override
	public void modifyUser(User user) throws ModifyException {
		userDao.updateUser(user);
	}

	@Override
	public void removeUser(int userNo) throws DeleteException {
		userDao.deleteUser(userNo);
	}

	@Override
	public User getUser(int userNo) throws FindException {
		return userDao.findUserById(userNo);
	}

	@Override
	public List<User> getAllUsers() throws FindException {
		return userDao.findAllUsers();
	}
}