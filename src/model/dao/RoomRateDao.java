package model.dao;

import java.util.List;

import model.dto.RoomRate;

public interface RoomRateDao {
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
