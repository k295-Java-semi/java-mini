package controller;

import model.dao.BookingDetailDao;
import model.dao.BookingDetailDaoImpl;
import model.dto.BookingDetail;

import java.util.List;

public class BookingDetailController {
    private BookingDetailDao bookingDetailDao = new BookingDetailDaoImpl();

    public List<BookingDetail> getAllBookingDetails() {
        return bookingDetailDao.findAllBookingDetails();
    }

    public List<BookingDetail> getBookingDetailById(int bookingDetailId) {
        return bookingDetailDao.findBookingDetailById(bookingDetailId);
    }

    public void addBookingDetail(BookingDetail bookingDetail) {
        bookingDetailDao.saveBookingDetail(bookingDetail);
    }

    public void updateBookingDetail(BookingDetail bookingDetail) {
        bookingDetailDao.updateBookingDetail(bookingDetail);
    }

    public void deleteBookingDetail(int bookingDetailId) {
        bookingDetailDao.deleteBookingDetail(bookingDetailId);
    }
}
