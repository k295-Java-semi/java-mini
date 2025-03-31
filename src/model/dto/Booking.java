package model.dto;

import java.sql.Date;

public class Booking {
    private int guestCount;
    private int bookingId;
    private int userId;
    private int roomId;
    private Date paymentDate;
    private int bookingDetailId;

    public Booking() {}

    public Booking(int bookingId, int userId, int roomId, Date paymentDate, int bookingDetailId) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.roomId = roomId;
        this.paymentDate = paymentDate;
        this.bookingDetailId = bookingDetailId;
    }

    public Booking(int i, String userId, int roomId) {
        this.bookingId = i;
        this.userId = Integer.parseInt(userId);
        this.roomId = roomId;
    }

    public Booking(int userId, int guestCount, Date paymentDate) {
        this.userId = userId;
        this.guestCount = guestCount;
        this.paymentDate = paymentDate;
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

    public int getBookingDetailId() {
        return bookingDetailId;
    }

    public void setBookingDetailId(int bookingDetailId) {
        this.bookingDetailId = bookingDetailId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId + '\'' +
                ", userId='" + userId + '\'' +
                ", roomId=" + roomId + '\'' +
                ", paymentDate=" + paymentDate + '\'' +
                ", bookingDetailId=" + bookingDetailId +
                '}';
    }
}