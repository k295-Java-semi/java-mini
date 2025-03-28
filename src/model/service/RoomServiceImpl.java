package model.service;

import java.util.List;

import model.dao.RoomDao;
import model.dao.RoomDaoImpl;
import model.dto.Room;
import pension.exception.DMLException;
import pension.exception.NotFoundException;

public class RoomServiceImpl implements RoomService {

	private static RoomService instance = new RoomServiceImpl();
	private RoomDao roomdao = RoomDaoImpl.getInstance();
	
	private RoomServiceImpl() {}
	
	public static RoomService getInstance() {
		return instance;
	}
	
	@Override
	public List<Room> getAllRooms() throws NotFoundException {
		List<Room> list = roomdao.selectAllRooms();
		if (list.isEmpty()) throw new NotFoundException("방이 존재하지 않습니다.");
		
		return list;
	}

	@Override
	public void addRoom(Room room) throws DMLException {
		int result = roomdao.addRoom(room);
		if (result == 0) throw new DMLException("등록 실패");
	}

	@Override
	public void modifyRoom(Room room) throws DMLException {
		int result = roomdao.updateRoom(room);
		if (result == 0) throw new DMLException("수정 실패");

	}

	@Override
	public void removeRoom(int roomId) throws DMLException {
		int result = roomdao.deleteRoom(roomId);
		if (result == 0) throw new DMLException("삭제 실패");
	}

}
