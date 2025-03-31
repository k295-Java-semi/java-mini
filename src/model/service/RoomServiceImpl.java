package model.service;

import java.util.List;

import model.dao.RoomDao;

import model.dao.RoomDaoImpl;
import model.dto.Room;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import pension.exception.SearchWrongException;
import session.Session;

public class RoomServiceImpl implements RoomService {

	private static RoomService instance = new RoomServiceImpl();
	private RoomDao roomdao = RoomDaoImpl.getInstance();
	
	private RoomServiceImpl() {}
	
	public static RoomService getInstance() {
		return instance;
	}
	
	/**
	 * 전체 방 조회
	 */
	@Override
	public List<Room> getAllRooms() throws NotFoundException {
		List<Room> list = roomdao.selectAllRooms();
		if (list.isEmpty()) throw new NotFoundException("방이 존재하지 않습니다.");
		
		return list;
	}
	
	/**
	 * 특정 방 조회
	 */
	@Override
	public Room getRoom(int roomId) throws SearchWrongException {
		Room room = roomdao.roomSelectByNo(roomId);
		if (room == null) throw new SearchWrongException("검색 결과가 없습니다.");
		
		return room;
	}
	
	/**
	 * 예약 가능한 방만 보여주는 메서드
	 */
	@Override
	public List<Room> isavaible() throws NotFoundException {
		List<Room> list = roomdao.isavaibleRooms();
		if (list.isEmpty()) throw new NotFoundException("방이 존재하지 않습니다.");
		return list;
	}

	/**
	 * 방 추가
	 */
	@Override
	public void addRoom(Room room) throws DMLException {
		int result = roomdao.addRoom(room);
		if (result == 0) throw new DMLException("등록 실패");
	}

	/**
	 * 방 수정
	 */
	@Override
	public void modifyRoom(Room room) throws DMLException {
		int result = roomdao.updateRoom(room);
		if (result == 0) throw new DMLException("수정 실패");

	}

	/**
	 * 방 삭제
	 */
	@Override
	public void removeRoom(int roomId) throws DMLException {
		int result = roomdao.deleteRoom(roomId);
		if (result == 0) throw new DMLException("삭제 실패");
	}

}
