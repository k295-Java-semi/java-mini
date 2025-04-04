package model.service;

import model.dao.BookingDetailDao;
import model.dto.BookingDetail;

import java.util.List;

public class BookingDetailServiceImpl implements BookingDetailService {
    private BookingDetailDao BookingDetailDao;

    public BookingDetailServiceImpl() {
        this.BookingDetailDao = BookingDetailDao;
    }

    @Override
    public List<BookingDetail> getAllBookingDetails() {
        return BookingDetailDao.findAllBookingDetails();
    }

    @Override
    public List<BookingDetail> getBookingDetailById(int id) {
        return BookingDetailDao.findBookingDetailById(id);
    }

    @Override
    public void addBookingDetail(BookingDetail bookingDetail) {
        BookingDetailDao.saveBookingDetail(bookingDetail);
    }

    @Override
    public int updateBookingDetail(BookingDetail bookingDetail) {
        return BookingDetailDao.updateBookingDetail(bookingDetail);
    }

    @Override
    public int deleteBookingDetail(int bookingDetailId) {
        return BookingDetailDao.deleteBookingDetail(bookingDetailId);
    }
}
