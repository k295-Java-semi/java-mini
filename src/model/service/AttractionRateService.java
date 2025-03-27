package model.service;

import model.dto.AttractionRate;

import java.sql.SQLException;
import java.util.List;

public interface AttractionRateService {
	
    void addAttractionRate(AttractionRate attractionRate) throws SQLException;

    List<AttractionRate> getAttractionRatesByAttractionId(int attractionId) throws SQLException;

    double getAverageAttractionRate(int attractionId) throws SQLException; 
    void updateAttractionRate(AttractionRate attractionRate) throws SQLException; 
    void deleteAttractionRate(int attractionRateId) throws SQLException; 

}