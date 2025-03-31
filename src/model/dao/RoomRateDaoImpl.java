package model.dao;

<<<<<<< HEAD
import model.dto.RoomRate;

import java.util.List;

public class RoomRateDaoImpl implements RoomRateDao {
    @Override
    public List<RoomRate> findAllRoomRates() {

        return null;
    }

    @Override
    public RoomRate findRoomRateById(int id) {
        return null;
    }

    @Override
    public void createRoomRate(RoomRate roomRate) {

    }

    @Override
    public void updateRoomRate(RoomRate rate) {

    }

    @Override
    public void deleteRoomRate(int id) {

    }

=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.AttractionRate;
import model.dto.RoomRate;
import util.DBManager;

public class RoomRateDaoImpl implements RoomRateDao {
	
  	@Override
    public int insertRoomRate(RoomRate roomRate) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "INSERT INTO room_rate (room_score, comment, visible, room_id) VALUES (?, ?, ?, ?)";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roomRate.getRoomScore());
            pstmt.setString(2, roomRate.getComment());
            pstmt.setBoolean(3, roomRate.isVisible());
            pstmt.setInt(4, roomRate.getRoomId());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
        }
        finally {
            DBManager.close(conn, pstmt, rs);
        }
		return result;
    }
  	
  	// 전체 방 평점 정보 조회
  	@Override
  	public List<RoomRate> selectAllRoomRates() throws SQLException{
  		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<RoomRate> roomRates = new ArrayList<>();
        String sql = "select * from room_rate";
        try {
        	conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	roomRates.add(new RoomRate(
                        rs.getInt("roomrate_id"),
                        rs.getInt("room_score"),
                        rs.getString("comment"),
                        rs.getBoolean("visible"),
                        rs.getInt("room_id")
                    ));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
        return roomRates;
  	}
  	
  	
    
    // 각 방 평점 정보 조회  
  	@Override
    public List<RoomRate> selectRoomRatesByRoomId(int roomId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<RoomRate> rates = new ArrayList<>();
        String sql = "SELECT * FROM room_rate WHERE room_id = ?";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roomId);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {    
                rates.add(new RoomRate(
                    rs.getInt("roomrate_id"),
                    rs.getInt("room_score"),
                    rs.getString("comment"),
                    rs.getBoolean("visible"),
                    rs.getInt("room_id")
                ));
            }
        }
        catch (SQLException e) {
			e.printStackTrace();
		} finally {
            DBManager.close(conn, pstmt, rs);
        }
        return rates;
    }
    
    // 각 방의 평점 정보 조회
  	@Override
    public RoomRate selectRoomRateById(int roomRateId) throws SQLException {
    	Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        RoomRate roomRate = null;
        String sql = "SELECT * FROM room_rate WHERE roomrate_id = ?";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roomRateId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                roomRate = new RoomRate(
                    rs.getInt("roomrate_id"),
                    rs.getInt("room_score"),
                    rs.getString("comment"),
                    rs.getBoolean("visible"),
                    rs.getInt("room_id")
                );
            }
        } catch (SQLException e) {
			e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return roomRate;
	}
    
    // 방 평점 수정 -> room_score, comment, visible(0,1) 전부 수정 가능
    @Override
    public int updateRoomRate(RoomRate roomRate) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "UPDATE room_rate SET room_score = ?, comment = ?, visible = ? WHERE roomrate_id = ?";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roomRate.getRoomScore());
            pstmt.setString(2, roomRate.getComment());
            pstmt.setBoolean(3, roomRate.isVisible());
            pstmt.setInt(4, roomRate.getRoomRateId()); 
            result = pstmt.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return result; 
    }
    // 방 평점 삭제
  	@Override
    public int deleteRoomRate(int roomRateId) throws SQLException {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "DELETE FROM room_rate WHERE roomrate_id = ?";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roomRateId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return result;
	}
  	
  	public boolean existsById(int roomRateId) {
        String sql = "SELECT COUNT(*) FROM room_rate WHERE roomrate_id = ?";
        try (Connection conn = DBManager.getConnection(); // DB 연결 클래스 가정
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, roomRateId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // 결과가 1 이상이면 해당 ID가 존재
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 발생 시 로그 출력 (실제로는 로깅 프레임워크 사용 권장)
        }
        return false; // 예외 발생 시 또는 결과가 없으면 false 반환
    }
>>>>>>> develop
}
