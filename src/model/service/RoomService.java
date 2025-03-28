package model.service;


import model.dto.Room;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import java.util.List;

public interface RoomService {
	
	/**
	 * 모든 방 정보 조회
	 */
    List<Room> getAllRooms() throws NotFoundException;

    /**
	 * 특정 방 조회
	 */
//	Room getRoom(int roomNo) throws FindException;

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