package controller;

import java.sql.Date;
import java.util.List;
import model.dao.BookingDao;
import model.dao.BookingDaoImpl;
import model.dto.Booking;
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
    }
}
