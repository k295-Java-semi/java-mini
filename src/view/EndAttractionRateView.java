package view;

import java.util.Scanner;

import controller.AttractionRateController;

public class EndAttractionRateView {

	private static Scanner sc = new Scanner(System.in);
	
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
