package model.service;


import java.util.List;

import model.dto.Booking;
import model.dto.BookingDetail;
import pension.exception.*;

public interface BookingService {
    // 모든 예약 조회
    List<Booking> getAllBookings() throws FindException;

    // 특정 예약 조회
	Booking getBooking(int bookingNo) throws FindException;

    // 예약 추가
    void addBooking(Booking booking, List<BookingDetail> bookingDetails) throws AddException, SQLException, java.sql.SQLException;

    // 예약 수정
    void modifyBooking(Booking booking) throws ModifyException;
    // 예약 취소 (삭제)
    void cancelBooking(int id) throws DeleteException;

	

}
