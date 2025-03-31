package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controller.RoomRateController;
import model.dao.RoomRateDaoImpl;
import model.dto.RoomRate;

public class EndRoomRateView {

	private static Scanner sc = new Scanner(System.in);
	
	public static void selectAllRoomRates() {
        System.out.println("전체 평점 조회:");
        try {
            RoomRateDaoImpl roomRateDao = new RoomRateDaoImpl();
            List<RoomRate> roomRates = roomRateDao.selectAllRoomRates();
            
            if (roomRates.isEmpty()) {
                MenuView.printError("등록된 평점이 없습니다.");
                return;
            }

            // 테이블 헤더 출력
            System.out.println("-------------------------------------------------------------");
            System.out.printf("| %-10s| %-10s| %-20s| %-7s| %-7s|\n",
                    "평점 ID", "평점", "코멘트", "공개 여부", "방 번호");
            System.out.println("-------------------------------------------------------------");

            // 데이터 출력
            for (RoomRate roomRate : roomRates) {
                System.out.printf("| %-10d | %-10d | %-20s| %-7s | %-7d |\n",
                        roomRate.getRoomRateId(),
                        roomRate.getRoomScore(),
                        roomRate.getComment(),
                        roomRate.isVisible() ? "공개" : "비공개",
                        roomRate.getRoomId());
            }
            System.out.println("-------------------------------------------------------------");
        } catch (SQLException e) {
            MenuView.printError("전체 평점 조회 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
	
	public static void addRoomRate() {
        System.out.print("사용자 ID를 입력해주세요: ");
        String userId = sc.nextLine();
        System.out.print("평점을 추가할 방 번호(room_id): ");
        int roomId = Integer.parseInt(sc.nextLine());
        System.out.print("평점(1-5): ");
        int score = Integer.parseInt(sc.nextLine());
        System.out.print("코멘트: ");
        String comment = sc.nextLine();
        RoomRateController.addRoomRate(userId, roomId, score, comment);
    }

	public static void viewRoomRatesById() {
        System.out.print("조회할 평점 ID(roomrate_id): ");
        int roomRateId = Integer.parseInt(sc.nextLine());
        RoomRateController.viewRoomRates(roomRateId);
    }


	public static void updateRoomRate() {
        try {
            System.out.print("수정할 평점 ID(roomrate_id): ");
            int roomRateId = Integer.parseInt(sc.nextLine());
            
            // roomRateId 존재 여부 확인 (가정: RoomRateDaoImpl에 existsById 메서드 추가)
            RoomRateDaoImpl roomRateDao = new RoomRateDaoImpl();
            if (!roomRateDao.existsById(roomRateId)) {
                MenuView.printError("입력한 평점 ID(roomrate_id: " + roomRateId + ")가 존재하지 않습니다.");
                return;
            }

            System.out.print("새 평점(1-5): ");
            int score = Integer.parseInt(sc.nextLine());
            if (score < 1 || score > 5) {
                MenuView.printError("평점은 1에서 5 사이여야 합니다.");
                return;
            }

            System.out.print("새 코멘트: ");
            String comment = sc.nextLine();

            System.out.print("공개 여부(true/false): ");
            boolean visible = Boolean.parseBoolean(sc.nextLine());

            RoomRateController.updateRoomRate(roomRateId, score, comment, visible);
            System.out.println("평점이 성공적으로 수정되었습니다.");
        } catch (NumberFormatException e) {
        	MenuView.printError("유효한 숫자를 입력해주세요.");
        } catch (Exception e) {
        	MenuView.printError("평점 수정 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

	public static void deleteRoomRate() {
        System.out.print("삭제할 평점 ID(roomrate_id): ");
        int roomRateId = Integer.parseInt(sc.nextLine());
        RoomRateController.deleteRoomRate(roomRateId);
    }
}
