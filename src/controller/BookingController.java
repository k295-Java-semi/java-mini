package controller;

import model.dto.Booking;
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
    }
}

