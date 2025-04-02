package model.service;

import java.util.List;

import model.dto.Room;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import pension.exception.SearchWrongException;

public interface RoomService {
	/**
	 * 모든 방 정보 조회
	 */
    List<Room> getAllRooms() throws NotFoundException;

    /**
	 * 특정 방 조회
	 */
	List<Room> getRoom(int roomId) throws SearchWrongException;
	
	/**
	 * 예약 가능한 방만 조회
	 */
	List<Room> isavaible() throws NotFoundException;

	/**
	 * 방 추가
	 */
    void addRoom(Room room) throws DMLException;

    /**
	 * 방 수정
	 */
	void modifyRoom(Room room) throws DMLException;

	/**
	 * 방 삭제
	 */
	void removeRoom(int roomId) throws DMLException;
}
