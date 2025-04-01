package model.dto;

import java.sql.Date;

public class    BookingDetail {
    private int bookingDetailId;
    private int guestCount;
    private int roomCount;
    private int totalPrice;
    private Date paymentDate;
    private Date checkInDate;
    private Date checkOutDate;
    private int bookingId;
    private int roomId;

    public BookingDetail() {}

    public BookingDetail(int bookingDetailId, int guestCount, int roomCount, int totalPrice, Date checkInDate, Date checkOutDate, Date paymentDate, int bookingId) {
        this.bookingDetailId = bookingDetailId;
        this.guestCount = guestCount;
        this.roomCount = roomCount;
        this.totalPrice = totalPrice;
        this.paymentDate = paymentDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingId = bookingId;
    }


    public int getBookingDetailId() {
        return bookingDetailId;
    }

    public void setBookingDetailId(int bookingDetailId) {
        this.bookingDetailId = bookingDetailId;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "BookingDetail{" +
                "bookingDetailId=" + bookingDetailId +
                ", guestCount=" + guestCount +
                ", roomCount=" + roomCount +
                ", totalPrice=" + totalPrice +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", bookingId=" + bookingId +
                '}';
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {this.roomId = roomId;}
}
