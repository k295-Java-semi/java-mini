package model.dto;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.dao.BookingDetailDao;
import model.dao.BookingDetailDaoImpl;

public class Booking {
    private int guestCount;
    private int bookingId;
    private int userId;
    private int roomId;
    private Date paymentDate;


    public List<BookingDetail> bookingDetailList = new ArrayList<>();

    public Booking() {

    }

    public Booking(int bookingId, int userId, int roomId, Date paymentDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.roomId = roomId;
        this.paymentDate = paymentDate;
    }

    public Booking(int userId, int roomId, Date paymentDate) {
        this.userId = userId;
        this.roomId = roomId;
        this.paymentDate = paymentDate;
    }

    public Booking(int bookingId, int userId, int roomId, LocalTime now) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.roomId = roomId;
    }

    public Booking(int i, String userId, int roomId) {
        this.bookingId = i;
        this.userId = Integer.parseInt(userId);
        this.roomId = roomId;
    }

    // Getters, Setters, toString

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId + '\'' +
                ", userId='" + userId + '\'' +
                ", roomId=" + roomId + '\'' +
                ", paymentDate=" + paymentDate + '\'' +
        '}';
    }

    public void addBookingDetail(BookingDetail bookingDetail) {
        BookingDetailDao bookingDetailDao = new BookingDetailDaoImpl();
        bookingDetailDao.saveBookingDetail(bookingDetail);
    }

    public List<BookingDetail> getBookingDetail() {
        BookingDetailDao bookingDetailDao = new BookingDetailDaoImpl();
        return bookingDetailDao.findBookingDetailById(this.bookingId);
    }

    public void setBookingDetail(List<BookingDetail> bookingDetail) {this.bookingDetailList = bookingDetail;}
}