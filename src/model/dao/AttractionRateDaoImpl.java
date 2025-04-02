package model.dao;

import model.dto.Attraction;
import model.dto.AttractionRate;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttractionRateDaoImpl implements AttractionRateDao {
	
    @Override
    public int insertAttractionRate(AttractionRate attractionRate) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "INSERT INTO attraction_rate (attraction_score, comment, attraction_id) VALUES (?, ?, ?)";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, attractionRate.getAttractionScore());
            pstmt.setString(2, attractionRate.getComment());
            pstmt.setInt(3, attractionRate.getAttractionId());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return result;
    }
    
    @Override
    public List<AttractionRate> selectAllAttractionRates() throws SQLException{
    	Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<AttractionRate> attractionRates = new ArrayList<>();
        String sql = "select * from attraction_rate";
        try {
        	conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	attractionRates.add(new AttractionRate(
                        rs.getInt("attractionrate_id"),
                        rs.getInt("attraction_score"),
                        rs.getString("comment"),
                        rs.getInt("attraction_id")
                    ));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
        return attractionRates;
    }

    @Override
    public List<AttractionRate> selectAttractionRatesByAttractionId(int attractionId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<AttractionRate> rates = new ArrayList<>();
        String sql = "SELECT * FROM attraction_rate WHERE attraction_id = ?";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, attractionId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                rates.add(new AttractionRate(
                    rs.getInt("attractionrate_id"),
                    rs.getInt("attraction_score"),
                    rs.getString("comment"),
                    rs.getInt("attraction_id")
                ));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return rates;
    }

    @Override
    public AttractionRate selectAttractionRateById(int attractionRateId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        AttractionRate attractionRate = null;
        String sql = "SELECT * FROM attraction_rate WHERE attractionrate_id = ?";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, attractionRateId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                attractionRate = new AttractionRate(
                    rs.getInt("attractionrate_id"),
                    rs.getInt("attraction_score"),
                    rs.getString("comment"),
                    rs.getInt("attraction_id")
                );
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return attractionRate;
    }

    
    @Override
    public int updateAttractionRate(AttractionRate attractionRate) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        
        String sql = "UPDATE attraction_rate SET attraction_score = ?, comment = ? WHERE attractionrate_id = ?";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, attractionRate.getAttractionScore());
            pstmt.setString(2, attractionRate.getComment());
            pstmt.setInt(3, attractionRate.getAttractionRateId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return result;
    }

    @Override
    public int deleteAttractionRate(int attractionRateId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
        
        String sql = "DELETE FROM attraction_rate WHERE attractionrate_id = ?";
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, attractionRateId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return result;
    }
}
