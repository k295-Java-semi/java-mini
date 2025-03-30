package model.dao;

import model.dto.Room;

import java.util.List;

public interface RoomDao {
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
