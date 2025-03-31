package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dto.RoomRate;

public interface RoomRateService {
	
	// 방 평점 추가
    void addRoomRate(RoomRate roomRate) throws SQLException;
    
    // 전체 방 평점 추가
    List<RoomRate> getAllRoomRates() throws SQLException;
    
    // 방 평점 방 아이디별 조회
    List<RoomRate> getRoomRatesByRoomId(int roomId) throws SQLException;
    
    // 방 평점 수정
    void updateRoomRate(RoomRate roomRate) throws SQLException; 
    
    // 방 평점 삭제
    void deleteRoomRate(int roomRateId) throws SQLException; 
}
