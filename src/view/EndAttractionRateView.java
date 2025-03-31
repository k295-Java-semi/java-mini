package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controller.AttractionRateController;
import model.dao.AttractionRateDaoImpl;
import model.dto.AttractionRate;

public class EndAttractionRateView {

	private static Scanner sc = new Scanner(System.in);
	
	public static void selectAllAttractionRates() {
        System.out.println("전체 관광지 평점 조회:");
        try {
            AttractionRateDaoImpl attractionRateDao = new AttractionRateDaoImpl();
            List<AttractionRate> attractionRates = attractionRateDao.selectAllAttractionRates();
            
            if (attractionRates.isEmpty()) {
                MenuView.printError("등록된 관광지 평점이 없습니다.");
                return;
            }

            // 테이블 헤더 출력
            System.out.println("-------------------------------------------------------------");
            System.out.printf("| %-12s | %-10s | %-20s | %-2s |\n",
                    "평점 ID", "평점", "코멘트", "관광지 번호");
            System.out.println("-------------------------------------------------------------");

            // 데이터 출력
            for (AttractionRate rate : attractionRates) {
                System.out.printf("| %-12d | %-10d | %-20s | %-2d |\n",
                        rate.getAttractionRateId(),
                        rate.getAttractionScore(),
                        rate.getComment(),
                        rate.getAttractionId());
            }
            System.out.println("-------------------------------------------------------------");
        } catch (SQLException e) {
            MenuView.printError("전체 관광지 평점 조회 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
	
	public static void addAttractionRate() {
        System.out.print("사용자 ID를 입력해주세요: ");
        String userId = sc.nextLine();
        System.out.print("평점을 추가할 관광지 번호(attraction_id): ");
        int attractionId = Integer.parseInt(sc.nextLine());
        System.out.print("평점(1-5): ");
        int score = Integer.parseInt(sc.nextLine());
        System.out.print("코멘트: ");
        String comment = sc.nextLine();
        AttractionRateController.addAttractionRate(userId, attractionId, score, comment);
    }

	public static void viewAttractionRatesById() {
        System.out.print("조회할 평점 ID(attractionrate_id): ");
        int attractionRateId = Integer.parseInt(sc.nextLine());
        AttractionRateController.viewAttractionRateById(attractionRateId);
    }

	public static void viewAttractionAverageScore() {
        System.out.print("조회할 관광지 번호(attraction_id): ");
        int attractionId = Integer.parseInt(sc.nextLine());
        AttractionRateController.viewAttractionRateById(attractionId);
    }

	public static void updateAttractionRate() {
        System.out.print("수정할 평점 ID(attractionrate_id): ");
        int attractionRateId = Integer.parseInt(sc.nextLine());
        System.out.print("새 평점(1-5): ");
        int score = Integer.parseInt(sc.nextLine());
        System.out.print("새 코멘트: ");
        String comment = sc.nextLine();
        AttractionRateController.updateAttractionRate(attractionRateId, score, comment);
    }

	public static void deleteAttractionRate() {
        System.out.print("삭제할 평점 ID(attractionrate_id): ");
        int attractionRateId = Integer.parseInt(sc.nextLine());
        AttractionRateController.deleteAttractionRate(attractionRateId);
    }
}
