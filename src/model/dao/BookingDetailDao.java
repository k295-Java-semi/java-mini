package model.dao;

import model.dto.BookingDetail;

import java.util.List;

public interface BookingDetailDao {
    
    // 예약 상세 전체 조회
    public List<BookingDetail> findAllBookingDetails();
    
    // 예약 상세 번호로 조회
    public BookingDetail findBookingDetailById();
    
    // 예약 상세 생성
    public void saveBookingDetail();

    int saveBookingDetail(BookingDetail bookingDetail);

    // 예약 상세 수정
    public void updateBookingDetail();

    int updateBookingDetail(BookingDetail bookingDetail);

    // 예약 상세 삭제
    public int deleteBookingDetail();
    
}
