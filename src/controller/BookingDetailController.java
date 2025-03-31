package controller;

import model.dto.BookingDetail;
import model.service.BookingDetailService;
import model.service.BookingDetailServiceImpl;

public class BookingDetailController {

    private BookingDetailService bookingDetailService = new BookingDetailServiceImpl();
    

    public BookingDetail getBookingDetailById(int id) {
        try {
            BookingDetail bookingDetail = bookingDetailService.getBookingDetailById(id);
            System.out.println(bookingDetail);
        } catch (Exception e) {
            System.out.println("예약 상세 조회 중 오류 발생: " + e.getMessage());
        }
        return null;
    }

    public void addBookingDetail(BookingDetail bookingDetail) {
        try {
            bookingDetailService.addBookingDetail(bookingDetail);
            System.out.println("예약 세부사항이 추가되었습니다.");
        } catch (Exception e) {
            System.out.println("예약 세부사항 추가 중 오류 발생: " + e.getMessage());
        }
    }

    public void updateBookingDetail(BookingDetail bookingDetail) {
        try {
            BookingDetail updatedBookingDetail = new BookingDetail(bookingDetail.getBookingDetailId(), bookingDetail.getGuestCount(), bookingDetail.getRoomCount(), bookingDetail.getTotalPrice(), bookingDetail.getCheckInDate(), bookingDetail.getCheckOutDate());
            bookingDetailService.updateBookingDetail(updatedBookingDetail);
            System.out.println("예약 세부사항이 수정되었습니다.");
        } catch (Exception e) {
            System.out.println("예약 세부사항 수정 중 오류 발생: " + e.getMessage());
        }
    }

    public void deleteBookingDetail(int id) {
        try {
            bookingDetailService.deleteBookingDetail(id);
            System.out.println("예약 세부사항이 삭제되었습니다.");
        } catch (Exception e) {
            System.out.println("예약 세부사항 삭제 중 오류 발생: " + e.getMessage());
        }
    }
}
