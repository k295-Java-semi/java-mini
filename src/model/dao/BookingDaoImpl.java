package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.dto.Booking;
import util.DBManager;

public class BookingDaoImpl implements BookingDao {
    @Override
    public List<Booking> selectAll() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Booking> bookings = null;

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM BOOKING");
            rs = pstmt.executeQuery();

            while(rs.next()){
                bookings.add(new Booking(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getDate(4), rs.getInt(5)));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(con, pstmt, rs);
        }


        return bookings;
    }

    @Override
    public Booking selectByNo(int bookingNo) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Booking booking = null;

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM BOOKING WHERE BOOKING_ID=?");
            rs = pstmt.executeQuery();

            pstmt.setInt(1, bookingNo);

            while(rs.next()){
                booking = new Booking(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getDate(4), rs.getInt(5));
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(con, pstmt, rs);
        }


        return booking;
    }

    @Override
    public void insert(Booking booking) {
        Connection con = null;
        PreparedStatement pstmt = null;

        int result = 0;

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("INSERT INTO BOOKING VALUES(?,?,?,?,?,?,?,?,?)");

            result = pstmt.executeUpdate();

            pstmt.setInt(1, booking.getBookingId());
            pstmt.setInt(2, booking.getUserId());
            pstmt.setInt(3, booking.getRoomId());
            pstmt.setDate(4,booking.getPaymentDate());

            if(result == 0){
                System.out.println("등록되지 않았습니다. 다시 시도해주세요.");
            }else{
                System.out.println("예약이 완료되었습니다. 상세내역은 마이페이지에서 확인해주세요!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt);
        }

    }

    @Override
    public void update(Booking booking) {
        Connection con = null;
        PreparedStatement pstmt = null;

        int result = 0;

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("UPDATE BOOKING SET USER_ID=?, ROOM_ID=?, PAYMENT_DATE=? WHERE BOOKING_ID=?");

            pstmt.setInt(1, booking.getUserId());
            pstmt.setInt(2, booking.getRoomId());
            pstmt.setDate(3,booking.getPaymentDate());
            pstmt.setInt(4, booking.getBookingId());

            result = pstmt.executeUpdate();

            if(result == 0){
                System.out.println("변경되지 않았습니다.");
            }else{
                System.out.println("예약 내역이 성공적으로 변경되었습니다. 상세 내역은 마이페이지에서 확인해주세요!");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(con, pstmt);
        }

    }

    @Override
    public void delete(int bookingNo) {
        Connection con = null;
        PreparedStatement pstmt = null;

        int result = 0;

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("DELETE FROM BOOKING WHERE BOOKING_ID=?");

            pstmt.setInt(1, bookingNo);

            result = pstmt.executeUpdate();

            if (result == 0) {
                System.out.println("취소되지 않았습니다. 예약 번호를 다시 확인해주세요!");
            }else{
                System.out.println("예약이 취소되었습니다. 다시 만나길!");
            }


        }catch(Exception e) {

        }finally {
            DBManager.close(con, pstmt);
        }

    }
}
