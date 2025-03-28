package controller;

import java.util.List;

import model.dto.Room;
import model.service.RoomService;
import model.service.RoomServiceImpl;
import pension.exception.DMLException;
import pension.exception.NotFoundException;
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
	
//	/**
//	 * 특정 방 정보 조회
//	 **/
//	public void getRoomById(int roomId) {
//		try {
//			roomService.
//		}
//	}
	
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
