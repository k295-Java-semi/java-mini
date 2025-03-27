package model.dao;


import model.dto.Room;

import java.util.List;

public interface RoomDao {
    List<Room> selectAllRooms() throws Exception;
}