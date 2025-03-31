package model.dao;

<<<<<<< HEAD
=======
import model.dto.RoomRate;

import java.sql.SQLException;
>>>>>>> develop
import java.util.List;

import model.dto.RoomRate;

public interface RoomRateDao {
<<<<<<< HEAD
    // 모든 방 리뷰 정보 조회
    public List<RoomRate> findAllRoomRates();

    // 특정 방 리뷰 정보 조회
    public RoomRate findRoomRateById(int id);

    // 방 리뷰 추가
	public void createRoomRate(RoomRate roomRate);

    // 방 리뷰 수정
    public void updateRoomRate(RoomRate rate);

    // 방 리뷰 삭제
    public void deleteRoomRate(int id);



}
=======
	
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
>>>>>>> develop
