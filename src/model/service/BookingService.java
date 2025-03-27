package model.service;


import model.dto.Booking;

import java.sql.SQLException;
import java.util.List;

public interface BookingService {
    void bookRoom(Booking booking, String checkIn, String checkOut) throws SQLException;
    List<Booking> getBookingsByUserId(String userId) throws SQLException;
}