package model.dao;

import java.util.List;

import model.dto.Booking;
import model.dto.BookingDetail;
import pension.exception.SQLException;

public interface BookingDao {
	// 모든 예약 조회
	public List<Booking> selectAll();

    // 특정 예약 조회
	public Booking selectByNo(int bookingNo);

    // 예약 추가
	public void insert(Booking booking, List<BookingDetail> bookingDetail) throws SQLException, java.sql.SQLException;

    // 예약 수정
	public void update(Booking booking);

    // 예약 취소 (삭제)
	public void delete(int bookingNo);

	List<Booking> selectByUserId(int userId);

	List<Booking> selectAllByUserId(int userId);
}
