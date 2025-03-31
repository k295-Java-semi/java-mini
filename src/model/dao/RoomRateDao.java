package model.dao;

import model.dto.RoomRate;

import java.sql.SQLException;

import java.util.List;


public interface RoomRateDao {
	
	// 방 평점 추가
    int insertRoomRate(RoomRate roomRate) throws SQLException;
    
    // 전체 방 평점 추가
    List<RoomRate> selectAllRoomRates() throws SQLException;
    
    // 빙 아이디에 따른 방 평점 조회 
    List<RoomRate> selectRoomRatesByRoomId(int roomId) throws SQLException;
    
    // 각 방의 평점 정보 조회
    RoomRate selectRoomRateById(int roomRateId) throws SQLException;
    
    // 방 요금 수정
    int updateRoomRate(RoomRate roomRate) throws SQLException;
    
    // 방 요금 삭제
    int deleteRoomRate(int roomRateId) throws SQLException;
}
