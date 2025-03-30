package model.service;

import java.util.List;

import model.dto.AttractionRate;

public interface AttractionRateService {
    // 모든 관광지 요금 정보 조회
    List<AttractionRate> getAllAttractionRates();

    // 특정 관광지 요금 정보 조회
    AttractionRate getAttractionRateById(int id);

    // 관광지 요금 추가
    void addAttractionRate(AttractionRate rate);

    // 관광지 요금 수정
    void updateAttractionRate(AttractionRate rate);

    // 관광지 요금 삭제
    void deleteAttractionRate(int id);
}
