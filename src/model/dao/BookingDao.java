package model.dao;

import java.util.List;

import model.dto.Booking;

public interface BookingDao {
	// 모든 예약 조회
	public List<Booking> selectAll();

    // 특정 예약 조회
	public Booking selectByNo(int bookingNo);

    // 예약 추가
	public void insert(Booking booking);

    // 예약 수정
	public void update(Booking booking);

    // 예약 취소 (삭제)
	public void delete(int bookingNo);

}
