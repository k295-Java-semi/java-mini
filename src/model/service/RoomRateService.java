package model.service;

import model.dto.RoomRate;

import java.sql.SQLException;
import java.util.List;

public interface RoomRateService {
    void addRoomRate(RoomRate roomRate) throws SQLException;
    List<RoomRate> getRoomRatesByRoomId(int roomId) throws SQLException;
    double getAverageRoomRate(int roomId) throws SQLException; 
    void updateRoomRate(RoomRate roomRate) throws SQLException; 
    void deleteRoomRate(int roomRateId) throws SQLException; 
}
