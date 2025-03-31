package controller;

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
    }
}
