package model.dao;

import model.dto.RoomRate;

import java.util.List;

public interface RoomRateDao {
    void insertRoomRate(RoomRate roomRate) throws Exception;
    List<RoomRate> selectRoomRatesByRoomId(int roomId) throws Exception;
}