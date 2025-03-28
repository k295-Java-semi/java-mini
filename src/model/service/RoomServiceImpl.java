package model.service;

import java.util.List;

import model.dao.RoomDao;
import model.dao.RoomDaoImpl;
import model.dto.Room;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import pension.exception.SearchWrongException;

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
	public Room getRoom(int roomId) throws SearchWrongException {
		Room room = roomdao.roomSelectByNo(roomId);
		if (room == null) throw new SearchWrongException("검색 결과가 없습니다.");
		
		return room;
	}

	@Override
	public void addRoom(Room room, int userId) throws DMLException {
		int result = roomdao.addRoom(room, userId);
		if (result == 0) throw new DMLException("등록 실패");
	}

	@Override
	public void modifyRoom(Room room, int userId) throws DMLException {
		int result = roomdao.updateRoom(room, userId);
		if (result == 0) throw new DMLException("수정 실패");

	}

	@Override
	public void removeRoom(int roomId, int userId) throws DMLException {
		int result = roomdao.deleteRoom(roomId, userId);
		if (result == 0) throw new DMLException("삭제 실패");
	}

}
