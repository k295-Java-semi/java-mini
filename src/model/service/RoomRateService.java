package model.service;

import java.util.List;

import model.dto.RoomRate;

public interface RoomRateService {
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
}
