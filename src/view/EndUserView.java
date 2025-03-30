package view;

import java.util.Scanner;

import controller.UserController;
import model.dto.User;
import session.Session;

public class EndUserView {
	
	private static Scanner sc = new Scanner(System.in);

	/**
	 * 회원가입
	 */
	public static void newRegister() {
		
		System.out.print("이름 : ");
	    String name = sc.nextLine();
	        
	    System.out.print("전화번호 : ");
	    String phone = sc.nextLine();
	        
	    System.out.print("이메일 : ");
	    String email = sc.nextLine();
	        
	    System.out.print("비밀번호 : ");
	    String password = sc.nextLine();
	        
	        // 입력받은 정보를 User 객체에 저장
	    User user = new User(name, phone, email, password);
	     
	    UserController.getInstance().register(user);
	}
	
	/**
	 * 로그인
	 */
	public static boolean userLogin() {
		
		System.out.print("이메일 : ");
	    String email = sc.nextLine();
	        
	    System.out.print("비밀번호 : ");
	    String password = sc.nextLine();
	    
	    boolean loginSuccess = UserController.getInstance().login(email, password);
	    return loginSuccess;
	}
	
	/**
	 * 회원 정보 수정
	 */
	public static void updateUserInfo() {
		Session session = UserController.getInstance().getSession();
		
		System.out.print("전화번호 : ");
	    String phone = sc.nextLine();
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("비밀번호 : ");
	    String password = sc.nextLine();
	    
	    User user = new User(session.getUserId(), email, password, phone);
	    
	    UserController.getInstance().updateInfo(session, user);
	}
	
	/**
	 * 로그아웃 처리
	 */
	public static void logoutUser() {
		Session session = UserController.getInstance().getSession();
		
		if (session != null) {
			UserController.getInstance().logout(session);
		} else {
			System.out.println("로그인 상태가 아닙니다.");
		}
	}
	
	public static void deleteUser() {
		Session session = UserController.getInstance().getSession();
		
		if (session != null) {
			UserController.getInstance().deleteUser(session);
		} else {
			System.out.println("로그인 상태가 아닙니다.");
		}
	}
}
