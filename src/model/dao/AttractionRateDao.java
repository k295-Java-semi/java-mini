package model.dao;

import model.dto.AttractionRate;

public interface AttractionRateDao {
    // 모든 관광지 요금 정보 조회
    public void findAllAttractionRates();

    // 특정 관광지 요금 정보 조회
    public void findAttractionRateById(int id);

    // 관광지 요금 정보 추가
    public void saveAttractionRate(AttractionRate rate);

    // 관광지 요금 정보 수정
    public void updateAttractionRate(AttractionRate rate);

    // 관광지 요금 정보 삭제
    public void deleteAttractionRate(int id);
}
