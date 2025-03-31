package model.dao;

import model.dto.AttractionRate;

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
