package model.service;

<<<<<<< HEAD
=======

import model.dto.Room;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import pension.exception.SearchWrongException;
import session.Session;

>>>>>>> develop
import java.util.List;

import model.dto.Room;
import pension.exception.AddException;
import pension.exception.DeleteException;
import pension.exception.FindException;
import pension.exception.ModifyException;

public interface RoomService {
<<<<<<< HEAD
    // 모든 방 정보 조회
    List<Room> getAllRooms() throws FindException;

    // 특정 방 정보 조회
	Room getRoom(int roomNo) throws FindException;

    // 방 추가
    void addRoom(Room room) throws AddException;

    // 방 정보 수정
	void modifyRoom(Room room) throws ModifyException;

    // 방 삭제
	void removeRoom(int roomNo) throws DeleteException;


}
=======
	
	/**
	 * 모든 방 정보 조회
	 */
    List<Room> getAllRooms() throws NotFoundException;

    /**
	 * 특정 방 조회
	 */
	Room getRoom(int roomId) throws SearchWrongException;
	
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
>>>>>>> develop
