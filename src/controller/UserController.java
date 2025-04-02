package controller;
import java.sql.SQLException;

import model.dto.User;
import model.service.UserService;
import model.service.UserServiceImpl;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import session.Session;
import view.FailView;
import view.SuccessView;

public class UserController {

	private static UserService userService = new UserServiceImpl();
	private Session session;
	private static UserController instance;
	
	public static UserController getInstance() {
		if (instance == null) {
			instance = new UserController();
		}
		return instance;
	}
	
	/**
	 * 회원가입 처리
	 */
	public void register(User user) { 
		
	     try {
	    	 userService.newRegister(user);
	    	 SuccessView.messagePrint("회원가입 성공");
	    	 
	     } catch (DMLException e) {
	    	 FailView.errorMessage(e.getMessage());
	     }
	}
	
	/**
	 * 로그인
	 */
	public boolean login(String email, String password) {
		 
	     try {
	    	 session = userService.login(email, password);
	    	 
	    	 if (session != null) {
	    		 System.out.println("session :"+session);
	    		 SuccessView.messagePrint("로그인 성공!");
	    		 return true;	    		 
	    	 } else {
	    		 FailView.errorMessage("로그인 실패");
	    		 return false;
	    	 }
	    	 
	     } catch (NotFoundException e) {
	    	 FailView.errorMessage(e.getMessage());
	    	 return false;
	     }
	}
	public Session getSession() {
		return session;
	}
	
	/**
	 * 회원 정보 조회
	 */
	public User userInfo(int userId) {
		try {
			User user = userService.userInfo(userId);
			return user;
		} catch (NotFoundException e) {
			FailView.errorMessage(e.getMessage());
			return null;
		}
		
	}
	
	/**
	 * 회원 정보 수정
	 */
	public void updateInfo(Session session, User user) {
		try {
			userService.updateUser(session, user);
			SuccessView.messagePrint("회원 정보 수정 완료");
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 로그아웃
	 */
	public void logout(Session session) {
		userService.logout(session);
	}
	
	/**
	 * 회원 탈퇴
	 */
	public void deleteUser(Session session) {
		try {
			userService.deleteUser(session);
			SuccessView.messagePrint("회원탈퇴가 완료되었습니다.");
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
