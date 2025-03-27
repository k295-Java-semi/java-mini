package model.dao;

import model.dto.AttractionRate;

import java.util.List;

public interface AttractionRateDao {
    void insertAttractionRate(AttractionRate attractionRate) throws Exception;
    List<AttractionRate> selectAttractionRatesByAttractionId(int attractionId) throws Exception;
}