package model.dao;

import model.dto.AttractionRate;

<<<<<<< HEAD
public interface AttractionRateDao {
    // 모든 관광지 요금 정보 조회
    public void findAllAttractionRates();

    // 특정 관광지 요금 정보 조회
    public void findAttractionRateById(int id);

    // 관광지 요금 정보 추가
    public void saveAttractionRate(AttractionRate rate);

    // 관광지 요금 정보 수정
    public void updateAttractionRate(AttractionRate rate);

    // 관광지 요금 정보 삭제
    public void deleteAttractionRate(int id);
}
=======
import java.sql.SQLException;
import java.util.List;

public interface AttractionRateDao {
	
	// 관광지 평점 추가
    int insertAttractionRate(AttractionRate attractionRate) throws SQLException;
    
    // 전체 관광지 평점 추가
    List<AttractionRate> selectAllAttractionRates() throws SQLException;
    
    // 관광지 아이디별 평점 조회
    List<AttractionRate> selectAttractionRatesByAttractionId(int attractionId) throws SQLException;
 
    // 관광지평점 아이디별 평점조회
    AttractionRate selectAttractionRateById(int attractionRateId) throws SQLException;
    
    // 관광지 평점 수정
    int updateAttractionRate(AttractionRate attractionRate) throws SQLException;
   
    // 관광지 평점 삭제
    int deleteAttractionRate(int attractionRateId) throws SQLException;
}
>>>>>>> develop
