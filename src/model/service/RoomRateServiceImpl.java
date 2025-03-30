package model.service;

import java.util.List;

import model.dao.RoomRateDao;
import model.dto.RoomRate;
import pension.exception.AddException;
import pension.exception.DeleteException;
import pension.exception.FindException;
import pension.exception.ModifyException;

public abstract class RoomRateServiceImpl implements RoomService {
	private RoomRateDao roomRateDao;

	public RoomRateServiceImpl(RoomRateDao roomRateDao) {
		this.roomRateDao =  roomRateDao;
	}

	public void addRoomRate(RoomRate roomRate) throws AddException {
		roomRateDao.createRoomRate(roomRate);
	}

	public void modifyRoom(RoomRate roomRate) throws ModifyException {
		roomRateDao.updateRoomRate(roomRate);
	}

	@Override
	public void removeRoom(int roomRateNo) throws DeleteException {
		roomRateDao.deleteRoomRate(roomRateNo);
	}

	public RoomRate getRoomRateById(int roomRateNo) throws FindException {
		return roomRateDao.findRoomRateById(roomRateNo);
	}

	public List<RoomRate> getAllRoomRate() throws FindException {
		return roomRateDao.findAllRoomRates();
	}
}