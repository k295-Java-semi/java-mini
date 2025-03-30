package model.service;

import java.util.List;

import model.dto.Room;
import pension.exception.AddException;
import pension.exception.DeleteException;
import pension.exception.FindException;
import pension.exception.ModifyException;

public interface RoomService {
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
