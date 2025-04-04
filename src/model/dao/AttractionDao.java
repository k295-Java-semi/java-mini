package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.dto.Attraction;

public interface AttractionDao {
	
	// 관광지 추가
	int insertAttraction(Attraction attraction) throws SQLException;
	
	// 관광지 전체 조회
	public List<Attraction> selectAllAttractions() throws SQLException;
	
	// 관광지 아이디별 조회
	public Attraction selectAttractionById(int attractionId) throws SQLException;
	
	// 관광지 수정
	public int updateAttraction(Attraction attraction) throws SQLException;
	 
	// 관광지 삭제
	public int deleteAttraction(int attractionId) throws SQLException;
}
