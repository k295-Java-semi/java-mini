package model.service;

import java.util.List;

import model.dao.BookingDao;
import model.dto.Booking;
import pension.exception.AddException;
import pension.exception.DeleteException;
import pension.exception.FindException;
import pension.exception.ModifyException;

public abstract class BookingServiceImpl implements BookingService {
	private BookingDao bookingDao;

	public BookingServiceImpl(BookingDao bookingDao) {
		this.bookingDao = bookingDao;
	}

	@Override
	public void addBooking(Booking booking) throws AddException {
		bookingDao.insert(booking);
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