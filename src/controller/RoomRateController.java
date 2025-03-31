package controller;

<<<<<<< HEAD
import model.dto.RoomRate;

public class RoomRateController {
    // 모든 방 요금 정보 조회
    public void getAllRoomRates() {
        // 서비스 호출 및 결과 반환
    }

    // 특정 방 요금 정보 조회
    public void getRoomRateById(int id) {
        // 서비스 호출 및 결과 반환
    }

    // 방 요금 추가
    public void addRoomRate(RoomRate rate) {
        // 서비스 호출 및 추가 작업
    }

    // 방 요금 수정
    public void updateRoomRate(int id, RoomRate rate) {
        // 서비스 호출 및 수정 작업
    }

    // 방 요금 삭제
    public void deleteRoomRate(int id) {
        // 서비스 호출 및 삭제 작업
=======
import java.sql.SQLException;
import java.util.List;

import model.dto.RoomRate;
import model.service.RoomRateService;
import model.service.RoomRateServiceImpl;
import view.MenuView;

public class RoomRateController {
   private static RoomRateService roomRateService = new RoomRateServiceImpl();
	
   public static void addRoomRate(String userId, int roomId, int score, String comment) {
        try {
            RoomRate roomRate = new RoomRate(0, score, comment, true, roomId);
            roomRateService.addRoomRate(roomRate);
            System.out.println("방 평점이 등록되었습니다.");
        } catch (SQLException e) {
            // MenuView.printError(e.getMessage());
        }
    }
   
   	// 전체 방 평점 조회
    public static List<RoomRate> selectAllRoomRates() throws SQLException{
	   return roomRateService.getAllRoomRates();
    }

    public static void viewRoomRates(int roomId) {
        try {
            roomRateService.getRoomRatesByRoomId(roomId).forEach(System.out::println);
        } catch (SQLException e) {
            // MenuView.printError(e.getMessage());
        }
    }

    public static void updateRoomRate(int roomRateId, int score, String comment, boolean visible) {
        try {
            RoomRate roomRate = new RoomRate(roomRateId, score, comment, visible, 0);
            roomRateService.updateRoomRate(roomRate);
        } catch (SQLException e) {
            MenuView.printError(e.getMessage());
        }
    }

    public static void deleteRoomRate(int roomRateId) {
        try {
            roomRateService.deleteRoomRate(roomRateId);
        } catch (SQLException e) {
            // MenuView.printError(e.getMessage());
        }
>>>>>>> develop
    }
}
