package controller;

import java.sql.SQLException;
import java.util.List;

import model.dto.AttractionRate;
import model.service.AttractionRateService;
import model.service.AttractionRateServiceImpl;

public class AttractionRateController {
	private static AttractionRateService attractionRateService = new AttractionRateServiceImpl();
	
	public static void addAttractionRate(String userId, int attractionId, int score, String comment) {
        try {
            AttractionRate attractionRate = new AttractionRate(0, score, comment, attractionId);
            attractionRateService.addAttractionRate(attractionRate);
            System.out.println("관광지 평점이 등록되었습니다.");
        } catch (SQLException e) {
            // MenuView.printError(e.getMessage());
        }
    }
	
	// 전체 관광지 평점 조회
	public static List<AttractionRate> selectAllAttractionRates() throws SQLException{
		return attractionRateService.getAllAttractionRates();
	}
	
	public static void viewAttractionRates(int attractionId) {
        try { 
            attractionRateService.getAttractionRatesByAttractionId(attractionId).forEach(System.out::println);
        } catch (SQLException e) {
            //MenuView.printError(e.getMessage());
        }
    }

    public static void viewAttractionRateById(int attractionRateId) {
        try {
            AttractionRate rate = attractionRateService.getAttractionRateById(attractionRateId);
            System.out.println(rate);
        } catch (SQLException e) {
            //MenuView.printError(e.getMessage());
        }
    }

    public static void updateAttractionRate(int attractionRateId, int score, String comment) {
        try {
            AttractionRate attractionRate = new AttractionRate(attractionRateId, score, comment, 0);
            attractionRateService.updateAttractionRate(attractionRate);
            System.out.println("관광지 평점이 수정되었습니다.");
        } catch (SQLException e) {
            //MenuView.printError(e.getMessage());
        }
    }

    public static void deleteAttractionRate(int attractionRateId) {
        try {
            attractionRateService.deleteAttractionRate(attractionRateId);
            System.out.println("관광지 평점이 삭제되었습니다.");
        } catch (SQLException e) {
            //MenuView.printError(e.getMessage());
        }
    }
}
