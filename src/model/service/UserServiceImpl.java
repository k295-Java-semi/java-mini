package model.service;

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
