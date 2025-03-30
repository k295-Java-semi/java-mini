package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.Room;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import pension.exception.SearchWrongException;
import session.Session;
import util.DBManager;

public class RoomDaoImpl implements RoomDao{
	
	private static RoomDao instance = new RoomDaoImpl();
	private UserDao userDao = UserDaoImpl.getInstance();
	
	private RoomDaoImpl() {}
	
	public static RoomDao getInstance() {
		return instance;
	}

	/**
	 * 전체 방 검색 메서드
	 * Query : select * from room;
	 **/
	@Override
	public List<Room> selectAllRooms() throws NotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from room";
		List<Room> list = new ArrayList<Room>();
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Room room = new Room(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
				list.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotFoundException("방 데이터가 없습니다.");
		} finally {
			DBManager.close(con, ps, rs);
		}
		return list;
	}
	
	/**
	 * 예약 가능한 방만 보여주는 메서드
	 * Query : select * from room where available = true
	 */
	@Override
	public List<Room> isavaibleRooms() throws NotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;
		
		String sql = "select * from where available = true";
		List<Room> availableRooms = new ArrayList<Room>();
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				room = new Room(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
			}
			availableRooms.add(room);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotFoundException("방이 없습니다.");
		} finally {
			DBManager.close(con, ps, rs);
		}
		
		return availableRooms;
	}
	
	
	
	
	/**
	 * 특정 방 정보 메서드
	 * Query : select * from room where room_id = ?
	 */
	@Override
	public Room roomSelectByNo(int roomId) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;
		String sql = "select * from room where room_id = ?";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, roomId);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				room = new Room(
		                rs.getInt(roomId),
		                rs.getString("room_name"),
		                rs.getString("type"),
		                rs.getInt("price"),             
		                rs.getInt("capacity"),
		                rs.getString("size"),
		                rs.getString("description"),      
		                rs.getBoolean("available")         
		            );
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("검색 결과가 없습니다.");
		} finally {
			DBManager.close(con, ps, rs);
		}
		
		return room;
	}
	

	/**
	 * 새로운 방 추가하는 메서드 (create)
	 * Query : insert into room (room_number, type, price, capacity, size, description)
	 * values(?,?,?,?,?,?)
	 **/
	@Override
	public int addRoom(Room room) throws DMLException {
		
//		try {
//			if (!userDao.roleCheck(session)) {
//				throw new DMLException("관리자 권한이 필요합니다.");
//			}
//		} catch (NotFoundException e) {
//			throw new DMLException("권한 확인 중 오류가 발생");
//		}
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into room (room_number, type, price, capacity, size, description)\r\n"
				+ "values(?,?,?,?,?,?)";
		
		try {	
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, room.getRoomNumber());
			ps.setString(2, room.getType());
			ps.setInt(3, room.getPrice());
			ps.setInt(4, room.getCapacity());
			ps.setString(5, room.getSize());
			ps.setString(6, room.getDescription());
			
			return ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("형식 오류");
		} finally {
			DBManager.close(con, ps, null);
		}
	}

	/**
	 * 방의 정보 수정하는 메서드 (update)
	 * Query : update room set room_number = ?, type = ?, price = ?, capacity = ?, size = ?, description = ? where roomId = ?
	 **/
	@Override
	public int updateRoom(Room room) throws DMLException {
//		try {
//			if (!userDao.roleCheck(session)) {
//				throw new DMLException("관리자 권한이 필요합니다.");
//			}
//		} catch (NotFoundException e) {
//			throw new DMLException("권한 확인 중 오류가 발생");
//		}
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update room set "
				+ "room_number = ?, type = ?, price = ?, capacity = ?, size = ?, description = ? where room_id = ?";
		
		try {
			
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, room.getRoomNumber());
			ps.setString(2,room.getType());
			ps.setInt(3, room.getPrice());
			ps.setInt(4, room.getCapacity());
			ps.setString(5, room.getSize());
			ps.setString(6, room.getDescription());
			ps.setInt(7, room.getRoomId());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("");
		} finally {
			DBManager.close(con, ps, null);
		} 
		return result;
	}

	/**
	 * 방 삭제 메서드 (delete)
	 * Query : delete from room where room_id = ?
	 **/
	@Override
	public int deleteRoom(int roomId) throws DMLException {
//		try {
//			if (!userDao.roleCheck(session)) {
//				throw new DMLException("관리자 권한이 필요합니다.");
//			}
//		} catch (NotFoundException e) {
//			throw new DMLException("권한 확인 중 오류가 발생");
//		}
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from room where room_id = ?";
		
		try {	
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, roomId);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("");
		} finally {
			DBManager.close(con, ps, null);
		}
		return result;
	}

	
}
