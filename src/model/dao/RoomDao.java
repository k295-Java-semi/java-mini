package model.dao;


import model.dto.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDao {
	
	/**
	 * 전체 방 검색 메서드
	 **/
    List<Room> selectAllRooms() throws SQLException;
    
    /**
	 * 새로운 방 추가하는 메서드 (create)
	 **/
    void addRoom(Room room, int userId) throws SQLException;
    
    /**
	 * 방의 정보 수정하는 메서드 (update)
	 **/
    void updateRoom(Room room, int userId) throws SQLException;
    
    /**
	 * 방 삭제 메서드 (delete)
	 **/
    void deleteRoom(int roomId, int userId) throws SQLException;
    
    
}