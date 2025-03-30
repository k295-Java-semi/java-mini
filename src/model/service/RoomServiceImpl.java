package model.service;

import java.util.List;

import model.dao.RoomDao;
import model.dto.Room;
import pension.exception.AddException;
import pension.exception.DeleteException;
import pension.exception.FindException;
import pension.exception.ModifyException;

public abstract class RoomServiceImpl implements RoomService {
	private RoomDao roomDao;

	public RoomServiceImpl(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public void addRoom(Room room) throws AddException {
		roomDao.saveRoom(room);
	}

	@Override
	public void modifyRoom(Room room) throws ModifyException {
		roomDao.updateRoom(room);
	}

	@Override
	public void removeRoom(int roomNo) throws DeleteException {
		roomDao.deleteRoom(roomNo);
	}

	@Override
	public Room getRoom(int roomNo) throws FindException {
		return roomDao.findRoomById(roomNo);
	}

	@Override
	public List<Room> getAllRooms() throws FindException {
		return roomDao.findAllRooms();
	}
}