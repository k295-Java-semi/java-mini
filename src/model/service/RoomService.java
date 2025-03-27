package model.service;


import model.dto.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomService {
    List<Room> getAllRooms() throws SQLException;
}