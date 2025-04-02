package model.service;

import model.dao.RoomRateDao;
import model.dao.RoomRateDaoImpl;
import model.dto.RoomRate;

import java.sql.SQLException;
import java.util.List;

public class RoomRateServiceImpl implements RoomRateService {
    private RoomRateDao roomRateDao = new RoomRateDaoImpl();

    @Override
    public void addRoomRate(RoomRate roomRate) throws SQLException {
        int result = roomRateDao.insertRoomRate(roomRate);
        if (result == 0) throw new SQLException("방 평점 등록에 실패하였습니다.");
    }
    
    // 전체 방 목록 조회
    @Override
	public List<RoomRate> getAllRoomRates() throws SQLException {
		List<RoomRate> roomrates = roomRateDao.selectAllRoomRates();
		if (roomrates == null || roomrates.isEmpty()) throw new SQLException("방 평점 목록이 업습니다.");
		return roomrates;
	}

    @Override
    public List<RoomRate> getRoomRatesByRoomId(int roomId) throws SQLException {
        List<RoomRate> rates = roomRateDao.selectRoomRatesByRoomId(roomId);
        if (rates == null || rates.isEmpty()) throw new SQLException("해당 방의 평점이 없습니다.");
        return rates;
    }
   
    @Override
    public void updateRoomRate(RoomRate roomRate) throws SQLException {
        int result = roomRateDao.updateRoomRate(roomRate);
        if (result == 0) throw new SQLException("방 평점 수정에 실패하였습니다.");
    }

    @Override
    public void deleteRoomRate(int roomRateId) throws SQLException {
        int result = roomRateDao.deleteRoomRate(roomRateId);
        if (result == 0) throw new SQLException("방 평점 삭제에 실패하였습니다.");
    }
}