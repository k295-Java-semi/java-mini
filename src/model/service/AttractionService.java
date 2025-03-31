package model.service;

import model.dto.Attraction;

import java.sql.SQLException;
import java.util.List;

public interface AttractionService {
	// 관광지 추가
    void addAttraction(Attraction attraction) throws SQLException;
    
    // 모든 관광지 조회
    List<Attraction> getAllAttractions() throws SQLException;
    
    // 관광지 아이디별 조회
    Attraction getAttractionById(int attractionId) throws SQLException;
    
    // 관광지 수정
    void updateAttraction(Attraction attraction) throws SQLException;
    
    // 관광지 삭제
    void deleteAttraction(int attractionId) throws SQLException;
}