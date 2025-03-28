package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dto.User;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import util.DBManager;

public class UserDaoImpl implements UserDao {
	
	private static UserDao instance = new UserDaoImpl();
	
	private UserDaoImpl() {}
	
	public static UserDao getInstance() {
		return instance;
	}

	/**
	 * 회원가입
	 * Query : 
	 */
	@Override
	public int newRegister(User user) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 회원 정보 수정
	 * Query : 
	 */
	@Override
	public int updateUser(User user) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 회원 탈퇴
	 * Query : 
	 */
	@Override
	public int deleteUser(int userId) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 권한 확인
	 * role : guest(false), admin(true)
	 * Query : select role from user where user_id = ?;
	 */
	@Override
	public boolean roleCheck(int userId) throws NotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
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
			throw new NotFoundException();
		} finally {
			DBManager.close(con, ps, rs);
		}
		
		
		return true;
	}

}
