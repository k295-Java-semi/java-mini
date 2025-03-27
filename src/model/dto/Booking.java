package model.dto;

import java.sql.Date;

public class Booking {
    private int bookingId;
    private String userId;
    private int roomId;
    private Date paymentDate;
    private int bookingDetailId;

    public Booking(int bookingId, String userId, int roomId, Date paymentDate, int bookingDetailId) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.roomId = roomId;
        this.paymentDate = paymentDate;
        this.bookingDetailId = bookingDetailId;
    }

    // Getters, Setters, toString


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
                "bookingId=" + bookingId +
                ", userId='" + userId + '\'' +
                ", roomId=" + roomId +
                ", paymentDate=" + paymentDate +
                ", bookingDetailId=" + bookingDetailId +
                '}';
    }
}