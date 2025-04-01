package model.dao;

import model.dto.BookingDetail;
import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingDetailDaoImpl implements BookingDetailDao {
    @Override
    public List<BookingDetail> findAllBookingDetails() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        BookingDetail bookingDetail = null;

        List<BookingDetail> bookingDetails = new ArrayList<>();

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM BOOKING_DETAIL");
            rs = pstmt.executeQuery();


            while(rs.next()){
                bookingDetail = new BookingDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                                rs.getInt(4), rs.getDate(5), rs.getDate(6), rs.getDate(7), rs.getInt(8));

                bookingDetails.add(bookingDetail);
            }


        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(con, pstmt, rs);
        }
        return bookingDetails;
    }

    @Override
    public List<BookingDetail> findBookingDetailById(int bookingId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<BookingDetail> bookingDetail = new ArrayList<>();
        int result = 0;

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM BOOKING_DETAIL WHERE BOOKING_ID=?");
            pstmt.setInt(1, bookingId);

            rs = pstmt.executeQuery();

            while(rs.next()){
                bookingDetail.add(new BookingDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getInt(4), rs.getDate(5), rs.getDate(6), rs.getDate(7), rs.getInt(8)));
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(con, pstmt, rs);
        }
        return bookingDetail;

    }

    @Override
    public int saveBookingDetail(BookingDetail bookingDetail) {
        Connection con = null;
        PreparedStatement pstmt = null;

        int result = 0;

        try {
            con = DBManager.getConnection();
<<<<<<< HEAD
            pstmt = con.prepareStatement("INSERT INTO BOOKING_DETAIL VALUES(?,?,?,?,?)");
=======
            con.setAutoCommit(false); // 트랜잭션 시작

            pstmt = con.prepareStatement(
                    "INSERT INTO BOOKING_DETAIL(guest_count, room_count, total_price, check_in_date, check_out_date, payment_date,booking_id) VALUES(?, ?, ?, ?, ?, ?,?)"
            );

            System.out.println("Booking Detail: " + bookingDetail.toString());
>>>>>>> feat/book

            pstmt.setInt(1, bookingDetail.getGuestCount());
            pstmt.setInt(2, bookingDetail.getRoomCount());
            pstmt.setInt(3, bookingDetail.getTotalPrice());
            pstmt.setDate(4, bookingDetail.getCheckInDate());
            pstmt.setDate(5, bookingDetail.getCheckOutDate());
<<<<<<< HEAD

            result = pstmt.executeUpdate();
            if(result == 0){
=======
            pstmt.setDate(6, bookingDetail.getPaymentDate());


            result = pstmt.executeUpdate();

            if (result == 0) {
                con.rollback(); // 트랜잭션 롤백
>>>>>>> feat/book
                System.out.println("예약 상세가 등록되지 않았습니다. 다시 시도해주세요.");
            } else {
                con.commit(); // 트랜잭션 커밋
                System.out.println("예약 상세가 등록되었습니다! 마이페이지에서 확인해주세요.");
            }

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback(); // 예외 발생 시 롤백
                }
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt);
        }
        return result;
    }

    @Override
    public int updateBookingDetail(BookingDetail bookingDetail) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int result = 0;

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("UPDATE BOOKING_DETAIL SET GUEST_COUNT=?, ROOM_COUNT=?, TOTAL_PRICE=?, CHECK_IN_DATE=?, CHECK_OUT_DATE=? WHERE BOOKING_DETAIL_ID=?");
            rs = pstmt.executeQuery();

            result = pstmt.executeUpdate();

            pstmt.setInt(1, bookingDetail.getGuestCount());
            pstmt.setInt(2, bookingDetail.getRoomCount());
            pstmt.setInt(3, bookingDetail.getTotalPrice());
            pstmt.setDate(4, bookingDetail.getCheckInDate());
            pstmt.setDate(5, bookingDetail.getCheckOutDate());
            pstmt.setInt(6, bookingDetail.getBookingDetailId());

            if(result == 0){
                System.out.println("수정되지 않았습니다. 다시 시도해주세요.");
            }else{
                System.out.println("예약이 수정되었습니다!");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(con, pstmt, rs);
        }
        return result;
    }

    @Override
    public int deleteBookingDetail(int bookingDetailId) {

        Connection con = null;
        PreparedStatement pstmt = null;

        int result = 0;

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("DELETE FROM BOOKING_DETAIL WHERE BOOKING_DETAIL_ID=?");
            result = pstmt.executeUpdate();

            if(result == 0){
                System.out.println("예약 상세 삭제에 실패했습니다. 다시 시도해주세요.");
            }else{
                System.out.println("예약 상세가 삭제되었습니다.");
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(con, pstmt);
        }
        return result;

    }
}
