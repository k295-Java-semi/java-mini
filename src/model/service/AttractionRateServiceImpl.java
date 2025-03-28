package model.service;

import model.dao.AttractionRateDao;
import model.dao.AttractionRateDaoImpl;
import model.dto.AttractionRate;

import java.sql.SQLException;
import java.util.List;

public class AttractionRateServiceImpl implements AttractionRateService {
    private AttractionRateDao attractionRateDao = new AttractionRateDaoImpl();

    @Override
    public void addAttractionRate(AttractionRate attractionRate) throws SQLException {
        int result = attractionRateDao.insertAttractionRate(attractionRate);
        if (result == 0) throw new SQLException("관광지 평점 등록에 실패하였습니다.");
    }
    
    @Override
	public List<AttractionRate> getAllAttractionRates() throws SQLException {
		List<AttractionRate> attractionrates = attractionRateDao.selectAllAttractionRates();
		if (attractionrates == null || attractionrates.isEmpty()) throw new SQLException("관광지 평점 목록이 없습니다.");
		return attractionrates;
	}

    @Override
    public List<AttractionRate> getAttractionRatesByAttractionId(int attractionId) throws SQLException {
        List<AttractionRate> rates = attractionRateDao.selectAttractionRatesByAttractionId(attractionId);
        if (rates == null || rates.isEmpty()) throw new SQLException("해당 관광지의 평점이 없습니다.");
        return rates;
    }

    @Override
    public AttractionRate getAttractionRateById(int attractionRateId) throws SQLException {
        AttractionRate rate = attractionRateDao.selectAttractionRateById(attractionRateId);
        if (rate == null) throw new SQLException("해당 평점이 존재하지 않습니다.");
        return rate;
    }

    @Override
    public void updateAttractionRate(AttractionRate attractionRate) throws SQLException {
        int result = attractionRateDao.updateAttractionRate(attractionRate);
        if (result == 0) throw new SQLException("관광지 평점 수정에 실패하였습니다.");
    }

    @Override
    public void deleteAttractionRate(int attractionRateId) throws SQLException {
        int result = attractionRateDao.deleteAttractionRate(attractionRateId);
        if (result == 0) throw new SQLException("관광지 평점 삭제에 실패하였습니다.");
    }



	
}