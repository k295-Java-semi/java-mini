package model.dao;


import model.dto.Booking;

import java.util.List;

public interface BookingDao {
    void insertBooking(Booking booking, String checkIn, String checkOut) throws Exception;
    List<Booking> selectBookingsByUserId(String userId) throws Exception;
}