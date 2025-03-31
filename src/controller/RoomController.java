package controller;
import java.util.ArrayList;
import java.util.List;

import model.dto.Room;
import model.service.RoomService;
import model.service.RoomServiceImpl;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import pension.exception.SearchWrongException;
import session.Session;
import view.FailView;
import view.SuccessView;

public class RoomController {
	private static RoomController instance;
	private static RoomService roomService = RoomServiceImpl.getInstance();
	
	public static RoomController getInstance() {
		if (instance == null) {
			instance = new RoomController();
		}
		return instance;
	}
	
	/**
	 * 모든 방 정보 조회
	 **/
	public List<Room> getAllRooms() {
		try {
			return roomService.getAllRooms();
		} catch (NotFoundException e) {
			FailView.errorMessage(e.getMessage());
			return new ArrayList<Room>();
		}
	}
	
	/**
	 * 특정 방 정보 조회
	 * @return 
	 **/
	public Room getRoomById(int roomId) {
		try {
			Room room = roomService.getRoom(roomId);
			return room;
		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
			return null;
		}
	}
	
	/**
	 * 예약 가능한 방만 조회
	 */
	public List<Room> isAvaibleRooms() {
		try {
			return roomService.isavaible();
		} catch (NotFoundException e) {
			FailView.errorMessage(e.getMessage());
			return new ArrayList<Room>();
		}
	}
	
	/**
	 * 방 추가
	 **/
	public void addRoom(Room room) {
		try {
			roomService.addRoom(room);
			SuccessView.messagePrint("방 등록 완료");
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 방 정보 수정
	 **/
	public void updateRoom(Room room) {
		try {
			roomService.modifyRoom(room);
			SuccessView.messagePrint("수정완료");
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 방 삭제
	 **/
	public void deleteRoom(int roomId) {
		try {
			roomService.removeRoom(roomId);
			SuccessView.messagePrint("삭제 완료");
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
