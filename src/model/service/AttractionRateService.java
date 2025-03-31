package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dto.AttractionRate;

public interface AttractionRateService {
	
	// 관광지 평점 추가
	void addAttractionRate(AttractionRate attractionRate) throws SQLException;
	
	// 모든 관광지 평점 추가
	List<AttractionRate> getAllAttractionRates() throws SQLException;
    
	// 관광지 아이디별 평점 조회
	List<AttractionRate> getAttractionRatesByAttractionId(int attractionId) throws SQLException;
    
    // 특정 관광지 평점 조회 
    AttractionRate getAttractionRateById(int attractionRateId) throws SQLException;
    
    // 평점 정보 수정
    void updateAttractionRate(AttractionRate attractionRate) throws SQLException;
    
    // 평점 정보 삭제
    void deleteAttractionRate(int attractionRateId) throws SQLException;

}
