package model.dao;

import model.dto.Room;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import pension.exception.SearchWrongException;
import session.Session;

import java.sql.SQLException;
import java.util.List;

public interface RoomDao {
<<<<<<< HEAD
    // 모든 방 정보 조회
    public List<Room> findAllRooms();

    // 특정 방 정보 조회
    public Room findRoomById(int id);

    // 방 추가
    public void saveRoom(Room room);

    // 방 정보 수정
    public void updateRoom(Room room);

    // 방 삭제
    public void deleteRoom(int id);


}
=======
	
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
	 **/
    int addRoom(Room room) throws DMLException;
//    int addRoom(Room room, Session session) throws DMLException;
    
    /**
	 * 방의 정보 수정하는 메서드 (update)
	 **/
    int updateRoom(Room room) throws DMLException;
//    int updateRoom(Room roo, Session session) throws DMLException;
    
    /**
	 * 방 삭제 메서드 (delete)
	 **/
    int deleteRoom(int roomId) throws DMLException;
//    int deleteRoom(int roomId, Session session) throws DMLException;
    
    /**
     * 특정 방 정보 메서드
     * ( 예약 가능한 방? 을 보여줘야 할듯?)
     */
    Room roomSelectByNo(int roomId) throws SearchWrongException;
    
}
>>>>>>> develop
