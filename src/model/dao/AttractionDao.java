package model.dao;

<<<<<<< HEAD
public interface AttractionDao {

    public void findAllAttractions();

    public void findAttractionById(int id);

    public void createAttraction(String name, String address, String tel, String url);

    public void updateAttraction(int id, String name, String address, String tel, String url);

    public void deleteAttraction(int id);

=======
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
>>>>>>> develop
}
