package model.dao;


import model.dto.Room;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import pension.exception.SearchWrongException;

import java.sql.SQLException;
import java.util.List;

public interface RoomDao {
	
	/**
	 * 전체 방 검색 메서드
	 **/
    List<Room> selectAllRooms() throws NotFoundException;
    
    /**
	 * 새로운 방 추가하는 메서드 (create)
	 * 권한 설정 추가해야됨
	 **/
    int addRoom(Room room, int userId) throws DMLException;
    
    /**
	 * 방의 정보 수정하는 메서드 (update)
	 **/
    int updateRoom(Room room, int userId) throws DMLException;
    
    /**
	 * 방 삭제 메서드 (delete)
	 **/
    int deleteRoom(int roomId, int userId) throws DMLException;
    
    /**
     * 특정 방 정보 메서드
     */
    Room roomSelectByNo(int roomId) throws SearchWrongException;
    
}