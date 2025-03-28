package model.dao;

import model.dto.Attraction;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttractionDaoImpl implements AttractionDao {
	
    @Override
    public int insertAttraction(Attraction attraction) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "INSERT INTO attraction (attraction_name, address, entrance, photo) VALUES (?, ?, ?, ?)";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, attraction.getAttractionName());
            pstmt.setString(2, attraction.getAddress());
            pstmt.setBoolean(3, attraction.isEntrance());
            pstmt.setString(4, attraction.getPhoto());
            result =  pstmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return result;
    }

    @Override
    public List<Attraction> selectAllAttractions() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Attraction> attractions = new ArrayList<>();
        String sql = "SELECT * FROM attraction";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                attractions.add(new Attraction(
                    rs.getInt("attraction_id"),
                    rs.getString("attraction_name"),
                    rs.getString("address"),
                    rs.getBoolean("entrance"),
                    rs.getString("photo")
                ));
            }
        } catch (SQLException e) {
			e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return attractions;
    }

    @Override
    public Attraction selectAttractionById(int attractionId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Attraction attraction = null;
        String sql = "SELECT * FROM attraction WHERE attraction_id = ?";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, attractionId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                attraction = new Attraction(
                    rs.getInt("attraction_id"),
                    rs.getString("attraction_name"),
                    rs.getString("address"),
                    rs.getBoolean("entrance"),
                    rs.getString("photo")
                );
            }
        } catch (SQLException e) {
			e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return attraction;
    }

    @Override
    public int updateAttraction(Attraction attraction) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        
        String sql = "UPDATE attraction SET attraction_name = ?, address = ?, entrance = ?, photo = ? WHERE attraction_id = ?";
        
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, attraction.getAttractionName());
            pstmt.setString(2, attraction.getAddress());
            pstmt.setBoolean(3, attraction.isEntrance());
            pstmt.setString(4, attraction.getPhoto());
            pstmt.setInt(5, attraction.getAttractionId());
            
            result = pstmt.executeUpdate();
            
        } catch (Exception e) {
			e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return result;
    }

    @Override
    public int deleteAttraction(int attractionId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        
        String sql = "DELETE FROM attraction WHERE attraction_id = ?";
        
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, attractionId);
            result = pstmt.executeUpdate();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return result;
    }
}