package model.service;

import java.util.List;

import model.dto.RoomRate;

public interface RoomRateService {
<<<<<<< HEAD
	// 모든 방 요금 정보 조회
	List<RoomRate> getAllRoomRates();

	// 특정 방 요금 정보 조회
	RoomRate getRoomRateById();

	// 방 요금 추가
	void addRoomRate();

	// 방 요금 수정
	void updateRoomRate();

	// 방 요금 삭제
	void deleteRoomRate();
=======
	
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
>>>>>>> develop
}
