package model.service;

import model.dao.AttractionDao;
import model.dao.AttractionDaoImpl;
import model.dto.Attraction;

import java.sql.SQLException;
import java.util.List;

public class AttractionServiceImpl implements AttractionService {
    private AttractionDao attractionDao = new AttractionDaoImpl();

    @Override
    public void addAttraction(Attraction attraction) throws SQLException {
        int result = attractionDao.insertAttraction(attraction);
        if (result == 0) throw new SQLException("관광지 추가에 실패하였습니다.");
    }

    @Override
    public List<Attraction> getAllAttractions() throws SQLException {
        List<Attraction> attractions = attractionDao.selectAllAttractions();
        if (attractions == null || attractions.isEmpty()) throw new SQLException("관광지 목록이 없습니다.");
        return attractions;
    }

    @Override
    public Attraction getAttractionById(int attractionId) throws SQLException {
        Attraction attraction = attractionDao.selectAttractionById(attractionId);
        if (attraction == null) throw new SQLException("해당 ID의 관광지가 존재하지 않습니다.");
        return attraction;
    }

    @Override
    public void updateAttraction(Attraction attraction) throws SQLException {
        int result = attractionDao.updateAttraction(attraction);
        if (result == 0) throw new SQLException("관광지 수정에 실패하였습니다.");
    }

    @Override
    public void deleteAttraction(int attractionId) throws SQLException {
        int result = attractionDao.deleteAttraction(attractionId);
        if (result == 0) throw new SQLException("관광지 삭제에 실패하였습니다.");
    }
}