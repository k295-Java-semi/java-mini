package controller;

import java.util.List;

import model.dto.Room;
import model.service.RoomService;
import model.service.RoomServiceImpl;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
import pension.exception.SearchWrongException;
import view.FailView;
import view.SuccessView;

public class RoomController {
	
	private static RoomService roomService = RoomServiceImpl.getInstance();
	
	/**
	 * 모든 방 정보 조회
	 **/
	public static void getAllRooms() {
		try {
			List<Room> list = roomService.getAllRooms();
			SuccessView.selectPrint(list);
		} catch (NotFoundException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 특정 방 정보 조회
	 **/
	public void getRoomById(int roomId) {
		try {
			Room room = roomService.getRoom(roomId);
			SuccessView.selectByNoPrint(room);
		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 방 추가
	 **/
	public void addRoom(Room room, int userId) {
		try {
			roomService.addRoom(room, userId);
			SuccessView.messagePrint("방 등록 완료");
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 방 정보 수정
	 **/
	public void updateRoom(Room room, int userId) {
		try {
			roomService.modifyRoom(room, userId);
			SuccessView.messagePrint("수정완료");
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 방 삭제
	 **/
	public void deleteRoom(int roomId, int userId) {
		try {
			roomService.removeRoom(roomId, userId);
			SuccessView.messagePrint("삭제 완료");
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
