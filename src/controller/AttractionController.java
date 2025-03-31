package controller;

<<<<<<< HEAD
public class AttractionController {

}
=======
import model.dto.Attraction;
import model.service.AttractionService;
import model.service.AttractionServiceImpl;
//import view.MenuView;

import java.sql.SQLException;
import java.util.List;

public class AttractionController {
    private static AttractionService attractionService = new AttractionServiceImpl();

    public static void addAttraction(String name, String address, boolean entrance, String photo) {
        try {
            Attraction attraction = new Attraction(0, name, address, entrance, photo);
            attractionService.addAttraction(attraction);
            System.out.println("관광지가 추가되었습니다.");
        } catch (SQLException e) {
            // MenuView.printError(e.getMessage());
        }
    }

    // 전체 관광지 조회
    public static List<Attraction> selectAllAttractions() throws SQLException {
        return attractionService.getAllAttractions();
    }

    public static Attraction selectAttractionById(int attractionId) throws SQLException {
        return attractionService.getAttractionById(attractionId);
    }

    public static void updateAttraction(int attractionId, String name, String address, boolean entrance, String photo) {
        try {
            Attraction attraction = new Attraction(attractionId, name, address, entrance, photo);
            attractionService.updateAttraction(attraction);
            System.out.println("관광지가 수정되었습니다.");
        } catch (SQLException e) {
            // MenuView.printError(e.getMessage());
        }
    }

    public static void deleteAttraction(int attractionId) {
        try {
            attractionService.deleteAttraction(attractionId);
            System.out.println("관광지가 삭제되었습니다.");
        } catch (SQLException e) {
            // MenuView.printError(e.getMessage());
        }
    }
}
>>>>>>> develop
