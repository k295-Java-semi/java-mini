package model.service;

import java.util.List;

import model.dao.BookingDao;
import model.dto.Booking;
import model.dto.BookingDetail;
import pension.exception.AddException;
import pension.exception.DeleteException;
import pension.exception.FindException;
import pension.exception.ModifyException;
import pension.exception.SQLException;

public class BookingServiceImpl implements BookingService {
	private BookingDao bookingDao;

	public BookingServiceImpl() {
		this.bookingDao = bookingDao;
	}
	
	public static BookingService getInstance() {
		return instance;
	}

	@Override
	public void addBooking(Booking booking, List<BookingDetail> bookingDetails) throws AddException, SQLException, java.sql.SQLException {
		bookingDao.insert(booking, bookingDetails);
	}

	@Override
	public void modifyBooking(Booking booking) throws ModifyException {
		bookingDao.update(booking);
	}

	@Override
	public void cancelBooking(int bookingNo) throws DeleteException {
		bookingDao.delete(bookingNo);
	}

	@Override
	public Booking getBooking(int bookingNo) throws FindException {
		return bookingDao.selectByNo(bookingNo);
	}

	@Override
	public List<Booking> getAllBookings() throws FindException {
		return bookingDao.selectAll();
	}
}