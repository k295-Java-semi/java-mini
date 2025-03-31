package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dto.User;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import session.Session;
import session.SessionSet;
import util.DBManager;

public class UserDaoImpl implements UserDao {
	
	private static UserDao instance = new UserDaoImpl();
	
	private UserDaoImpl() {}
	
	public static UserDao getInstance() {
		return instance;
	}

	/**
	 * 회원가입
	 * Query : insert into user (name, phone, email, password) values (?, ?, ?, ?)
	 */
	@Override
	public int newRegister(User user) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "insert into user (name, phone, email, password) values (?, ?, ?, ?)";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("회원 가입 중 오류가 발생했습니다.");
		} finally {
			DBManager.close(con, ps, null);	
		}
		
	}
	
	/**
	 * 로그인
	 * Query : select user_id, role from user where email = ? and password = ?
	 */
	@Override
	public Session login(String email, String password) throws NotFoundException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_id, role from user where email = ? and password = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				int userId = rs.getInt("user_id");
				String role = rs.getString("role");
				return new Session(userId, role);
			} else {
				throw new NotFoundException("이메일 또는 비밀번호가 틀렸습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotFoundException("사용자가 없습니다.");
			
		} finally {
			DBManager.close(con, ps, rs);
		}
	}
	
	/**
	 * 회원 정보 조회
	 * Query : select * from user where user_id = ?
	 */
	@Override
	public User userInfo(int userId) throws NotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		String sql = "select * from user where user_id = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				user = new User(name, phone, email, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotFoundException("사용자가 없습니다.");
		} finally {
			DBManager.close(con, ps, rs);
		}
		return user;
	}
	
	
	/**
	 * 회원 정보 수정
	 * Query : update user set email = ?, password = ?, name = ? where user_id = ?
	 */
	@Override
	public int updateUser(Session session, User user) throws DMLException {
		if (session == null) {
			throw new DMLException("로그인 상태에서만 회원 정보를 수정할 수 있습니다.");
		}
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update user set email = ?, password = ?, name = ? where user_id = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setInt(4, session.getUserId());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("회원 정보 수정 중 오류가 발생했습니다.");
		} finally {
			DBManager.close(con, ps, null);
		}
	}
	
	/**
	 * 로그아웃
	 * Query : 
	 */
	@Override
	public void logout(Session session) {
		if (session != null) {
			SessionSet.getInstance().remove(session);
		}
	}

	/**
	 * 회원 탈퇴
	 * Query : delete from user where user_id = ?
	 */
	@Override
	public int deleteUser(Session session) throws DMLException {
		if (session == null) {
			throw new DMLException("사용자가 로그인하지 않았다.");
		}
		
		int userId = session.getUserId();
		
		Connection con = null;
		PreparedStatement ps = null;
		
		SessionSet sessionSet = SessionSet.getInstance();
		Session sessionRemove = null;
		
		for (Session se : sessionSet.getSet()) {
			if (se.getUserId() == userId) {
				sessionRemove = se;
				break;
			}
		}
		
		if (sessionRemove != null) {
			sessionSet.remove(sessionRemove);
		}
		
		String sql = "delete from user where user_id = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("회원 탈퇴 중 오류가 발생");
		} finally {
			DBManager.close(con, ps, null);
		}
	}

	/**
	 * 권한 확인
	 * role : guest(false), admin(true)
	 * Query : select role from user where user_id = ?;
	 */
	@Override
	public boolean roleCheck(Session session) throws NotFoundException {
		if (session == null) {
			throw new NotFoundException("사용자가 로그인하지 않았다.");
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int userId = session.getUserId();
		
		String sql = "select role from user where user_id = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				String role = rs.getString("role");
				return "admin".equals(role);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotFoundException("권한 확인 중 오류 발생");
		} finally {
			DBManager.close(con, ps, rs);
		}
		
		
		return false;
	}

}
