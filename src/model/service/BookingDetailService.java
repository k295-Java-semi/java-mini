package model.service;

import model.dto.BookingDetail;

import java.util.List;

public interface BookingDetailService {
	//모든 예약 상세 조회
    public List<BookingDetail> getAllBookingDetails();

    //예약 상세 번호를 통한 조회
    public BookingDetail getBookingDetailById(int id);

    //예약 상세 생성
    void addBookingDetail(BookingDetail bookingDetail);

    // 예약 상세 수정
    int updateBookingDetail(BookingDetail bookingDetail);

    //예약 상세 삭제
    int deleteBookingDetail(int id);
}
