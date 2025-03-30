package model.service;

import java.util.List;

import model.dto.AttractionRate;

public class AttractionRateServiceImpl implements AttractionRateService {
    private AttractionRateServiceImpl AttractionRateServiceImpl;

    @Override
    public List<AttractionRate> getAllAttractionRates() {
        return null;
    }

    @Override
    public AttractionRate getAttractionRateById(int id) {
        return null;
    }

    @Override
    public void addAttractionRate(AttractionRate rate) {
        AttractionRateServiceImpl.addAttractionRate(rate);
    }

    @Override
    public void updateAttractionRate(AttractionRate rate) {
        AttractionRateServiceImpl.updateAttractionRate(rate);
    }

    @Override
    public void deleteAttractionRate(int id) {
        AttractionRateServiceImpl.deleteAttractionRate(id);
    }
}
