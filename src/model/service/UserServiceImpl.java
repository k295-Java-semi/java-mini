package model.service;

<<<<<<< HEAD
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
=======
import model.dao.UserDao;
import model.dao.UserDaoImpl;
import model.dto.User;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import session.Session;

public class UserServiceImpl implements UserService {

	private UserDao userDao = UserDaoImpl.getInstance();
	
	/**
	 * 회원가입
	 */
	@Override
	public void newRegister(User user) throws DMLException {
		int result = userDao.newRegister(user);
		if (result == 0) {
			throw new DMLException("회원가입 실패");
		}
	}

	/**
	 * 로그인
	 */
	@Override
	public Session login(String email, String password) throws NotFoundException {
		
		return userDao.login(email, password);
	}
	
	/**
	 * 회원 정보 조회
	 */
	@Override
	public User userInfo(int userId) throws NotFoundException {
		User user = userDao.userInfo(userId);
		if (user == null) {
			throw new NotFoundException("사용자가 없습니다.");
		}
		return user;
	}

	/**
	 * 회원 정보 수정
	 */
	@Override
	public void updateUser(Session session, User user) throws DMLException {
		int result = userDao.updateUser(session, user);
		if (result == 0) {
			userDao.updateUser(session, user);
		}
		
	}

	/**
	 * 로그아웃
	 */
	@Override
	public void logout(Session session) {
		
		userDao.logout(session);

	}

	/**
	 * 회원탈퇴
	 */
	@Override
	public void deleteUser(Session session) throws DMLException {
		int result = userDao.deleteUser(session);
		if (result == 0) {
			throw new DMLException("회원 탈퇴 실패");
		}
		
	}

	/**
	 * 권한 확인
	 */
	@Override
	public boolean roleCheck(Session session) throws NotFoundException {
		
		return userDao.roleCheck(session);
	}

}
>>>>>>> develop
