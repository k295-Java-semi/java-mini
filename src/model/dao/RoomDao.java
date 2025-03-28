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
	 * ( 예약 상태도 컬럼에 잇으니 생각 해봄)
	 **/
    List<Room> selectAllRooms() throws NotFoundException;
    
    /**
     * 예약을 할 때 예약 가능한 방만을 보여줘야 되는 메서드?
     */
    List<Room> isavaibleRooms() throws NotFoundException;
    
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
     * ( 예약 가능한 방? 을 보여줘야 할듯?)
     */
    Room roomSelectByNo(int roomId) throws SearchWrongException;
    
}