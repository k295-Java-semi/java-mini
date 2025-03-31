package view;

import java.util.Scanner;

import controller.AttractionController;
import model.dto.Attraction;

public class EndAttractionView {

	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 관광지 추가
	 */
	public static void addAttraction() {
        System.out.print("관광지 이름: ");
        String name = sc.nextLine();
        System.out.print("주소: ");
        String address = sc.nextLine();
        System.out.print("입장 가능 여부(true/false): ");
        boolean entrance = Boolean.parseBoolean(sc.nextLine());
        System.out.print("사진 파일명: ");
        String photo = sc.nextLine();
        AttractionController.addAttraction(name, address, entrance, photo);
    }
	
	/**
	 * 관광지 조회
	 */
	public static void viewAttractionById() {
        System.out.print("조회할 관광지 ID(attraction_id): ");
        int attractionId = Integer.parseInt(sc.nextLine());
        try {
            Attraction attraction = AttractionController.selectAttractionById(attractionId);
            if (attraction != null) {
                System.out.println("----------------------------------------------------------");
                System.out.printf("| %-11s | %-20s | %-50s | %-8s |\n", "ID", "이름", "주소", "입장 여부");
                System.out.println("----------------------------------------------------------");
                System.out.printf("| %-11d | %-20s | %-50s | %-8s |\n",
                    attraction.getAttractionId(), attraction.getAttractionName(), attraction.getAddress(),
                    attraction.isEntrance() ? "가능" : "불가");
                System.out.println("----------------------------------------------------------");
            } else {
                MenuView.printError("해당 관광지가 존재하지 않습니다.");
            }
        } catch (Exception e) {
            MenuView.printError(e.getMessage());
        }
    }

	/**
	 * 관광지 수정
	 */
    public static void updateAttraction() {
        System.out.print("수정할 관광지 ID(attraction_id): ");
        int attractionId = Integer.parseInt(sc.nextLine());
        System.out.print("새 이름: ");
        String name = sc.nextLine();
        System.out.print("새 주소: ");
        String address = sc.nextLine();
        System.out.print("새 입장 가능 여부(true/false): ");
        boolean entrance = Boolean.parseBoolean(sc.nextLine());
        System.out.print("새 사진 파일명: ");
        String photo = sc.nextLine();
        AttractionController.updateAttraction(attractionId, name, address, entrance, photo);
    }

    /**
	 * 관광지 삭제
	 */
    public static void deleteAttraction() {
        System.out.print("삭제할 관광지 ID(attraction_id): ");
        int attractionId = Integer.parseInt(sc.nextLine());
        AttractionController.deleteAttraction(attractionId);
    }
}
