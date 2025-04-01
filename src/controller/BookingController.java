package controller;

import java.sql.Date;
import java.util.List;
import model.dao.BookingDao;
import model.dao.BookingDaoImpl;
import model.dto.Booking;
<<<<<<< HEAD
import model.service.BookingService;
import model.service.BookingServiceImpl;

import java.util.List;

public class BookingController {

    private BookingService bookingService = new BookingServiceImpl();

    // 모든 예약 조회
    public void getAllBookings() {
        try {
            bookingService.getAllBookings().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("예약 조회 중 오류 발생: " + e.getMessage());
        }
    }

    // 특정 예약 조회
    public List<Booking> getBookingById(int id) {
        try {
            Booking booking = bookingService.getBooking(id);
            System.out.println(booking);
        } catch (Exception e) {
            System.out.println("예약 조회 중 오류 발생: " + e.getMessage());
        }
        return null;
    }

    // 예약 생성
    public void addBooking(Booking booking) {
        try {
            bookingService.addBooking(booking);
            System.out.println("예약이 추가되었습니다.");
        } catch (Exception e) {
            System.out.println("예약 추가 중 오류 발생: " + e.getMessage());
        }
    }

    // 예약 수정
    public void updateBooking(int id, Booking booking) {
        try {
            Booking updatedBooking = new Booking(id, booking.getUserId(), booking.getRoomId(), booking.getPaymentDate(), booking.getBookingDetailId());
            bookingService.modifyBooking(updatedBooking);
            System.out.println("예약이 수정되었습니다.");
        } catch (Exception e) {
            System.out.println("예약 수정 중 오류 발생: " + e.getMessage());
        }
    }

    // 예약 취소
    public void cancelBooking(int id) {
        try {
            bookingService.cancelBooking(id);
            System.out.println("예약이 취소되었습니다.");
        } catch (Exception e) {
            System.out.println("예약 취소 중 오류 발생: " + e.getMessage());
        }
=======
import model.dto.BookingDetail;
import pension.exception.SQLException;

import static java.time.LocalTime.now;

public class BookingController {
    private BookingDao bookingDao = new BookingDaoImpl();

    public List<Booking> getAllBookings() {
        return bookingDao.selectAll();
    }

    public List<Booking> getBookingsByUserId(int userId) {
        return bookingDao.selectAllByUserId(userId);
    }

    public void addBooking(int userId, int roomId, String dateStr) throws SQLException, java.sql.SQLException {
        Date paymentDate = Date.valueOf(dateStr);
        Booking booking = new Booking(userId, roomId, paymentDate);
        bookingDao.insert(booking, null);
    }

    public void updateBooking(int bookingId, int userId, int roomId, String dateStr) {
        Date paymentDate = Date.valueOf(dateStr);
        Booking booking = new Booking(bookingId, userId, roomId, paymentDate);
        bookingDao.update(booking);
    }

    public void deleteBooking(int bookingId) {
        bookingDao.delete(bookingId);
    }

    public List<Booking> getBookingByUserId(int userId) {
        return bookingDao.selectByUserId(userId);
    }

    public void addBooking(Booking booking, List<BookingDetail> bookingDetails) throws SQLException, java.sql.SQLException {
        bookingDao.insert(booking, bookingDetails);
    }

    public Booking getBookingByBookingDetailId(int bookingDetailId) {
        return bookingDao.selectByNo(bookingDetailId);
>>>>>>> feat/book
    }
}
