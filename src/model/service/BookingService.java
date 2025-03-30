package model.service;


import java.util.List;

import model.dto.Booking;
import pension.exception.AddException;
import pension.exception.DeleteException;
import pension.exception.FindException;
import pension.exception.ModifyException;

public interface BookingService {
    // 모든 예약 조회
    List<Booking> getAllBookings() throws FindException;

    // 특정 예약 조회
	Booking getBooking(int bookingNo) throws FindException;

    // 예약 추가
    void addBooking(Booking booking) throws AddException;

    // 예약 수정
    void modifyBooking(Booking booking) throws ModifyException;
    // 예약 취소 (삭제)
    void cancelBooking(int id) throws DeleteException;

	

}
