package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dto.Booking;
import model.dto.BookingDetail;
import pension.exception.SQLException;
import util.DBManager;

public class BookingDaoImpl implements BookingDao {
<<<<<<< HEAD
	
	private static BookingDao instance = new BookingDaoImpl();
	private UserDao userDao = UserDaoImpl.getInstance();
	
	private BookingDaoImpl() {}
	
	public static BookingDao getInstance() {
		return instance;
	}
	
=======

    private BookingDetail bookingDetail;

>>>>>>> feat/book
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
                bookings.add(new Booking(rs.getInt("booking_id"), rs.getInt("user_id"),
                        rs.getInt("room_id"), rs.getDate("payment_date")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(con, pstmt, rs);
        }


        return bookings;
    }

    public List<Booking> selectAllByUserId(int userId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Booking> bookings = new ArrayList<>();

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM BOOKING WHERE user_id = ?");
            pstmt.setInt(1, userId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("booking_id"),
                        rs.getInt("user_id"),
                        rs.getInt("room_id"),
                        rs.getDate("payment_date")
                );
                bookings.add(booking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return bookings;
    }

    public List<Booking> selectByUserId(int userId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Booking> bookings = new ArrayList<>();

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM BOOKING WHERE user_id = ?");
            pstmt.setInt(1, userId);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("booking_id"),
                        rs.getInt("user_id"),
                        rs.getInt("room_id"),
                        rs.getDate("payment_date")
                );
                List<BookingDetail> bookingDetails = this.selectById(rs.getInt("booking_id"));
                booking.setBookingDetail(bookingDetails);

                bookings.add(booking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return bookings;
    }
    public List<BookingDetail> selectById(int bookingId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<BookingDetail> bookingDetails = new ArrayList<>();


        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM BOOKING_DETAIL WHERE BOOKING_ID=?");
            pstmt.setInt(1, bookingId);

            rs = pstmt.executeQuery();

            while(rs.next()){
                BookingDetail bookingDetail1 = new BookingDetail(rs.getInt("booking_detail_id"), rs.getInt("guest_count"), rs.getInt("room_count"),
                        rs.getInt("total_price"), rs.getDate("check_in_date"), rs.getDate("check_out_date"), rs.getDate("payment_date"), rs.getInt("booking_id"));

                bookingDetails.add(bookingDetail1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(con, pstmt, rs);
        }
        return bookingDetails;
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
            pstmt.setInt(1, bookingNo);

            rs = pstmt.executeQuery();

            while(rs.next()){
                booking = new Booking(rs.getInt("booking_id"), rs.getInt("user_id"),
                        rs.getInt("room_id"), rs.getDate("payment_date"));
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(con, pstmt, rs);
        }


        return booking;
    }

    @Override
    public void insert(Booking booking, List<BookingDetail> bookingDetails) throws SQLException, java.sql.SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getConnection();
            con.setAutoCommit(false); // 트랜잭션 시작

            // BOOKING 테이블에 데이터 삽입
            pstmt = con.prepareStatement(
                    "INSERT INTO BOOKING(user_id, room_id, payment_date) VALUES(?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            // 바인딩된 데이터 출력
            System.out.println("Inserting into BOOKING: bookingId=" + booking.getBookingId() + ", userId=" + booking.getUserId() +
                    ", roomId=" + booking.getRoomId() +
                    ", paymentDate=" + booking.getPaymentDate());

            pstmt.setInt(1, booking.getUserId());
            pstmt.setInt(2, booking.getRoomId());
            pstmt.setDate(3, booking.getPaymentDate());

            int result = pstmt.executeUpdate();

            // BOOKING 삽입 확인
            if (result > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedBookingId = generatedKeys.getInt(1);
                    System.out.println("Generated BOOKING ID: " + generatedBookingId);

                    booking.setBookingId(generatedBookingId);//??

                     result = saveBookingDetail(con, bookingDetails, generatedBookingId);
                     System.out.println("Detail result = " + result);
                     if(result >= 1){
                         con.commit();

                     }else{
                         con.rollback();
                     }
                } else {
                    System.out.println("BOOKING ID 생성에 실패했습니다. 삽입 쿼리가 실행되지 않았습니다.");
                    con.rollback(); // 롤백
                    return;
                }
            } else {
                System.err.println("BOOKING 삽입 실패. result = " + result);
                con.rollback(); // 롤백
                return;
            }

            con.commit(); // 트랜잭션 커밋
        } catch (Exception e) {
            if (con == null) {
                try {
                    con.rollback(); // 오류 롤백
                    System.err.println("트랜잭션 롤백 실행");
                } catch (java.sql.SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            e.printStackTrace();
            System.err.println("오류 메시지: " + e.getMessage());
        } finally {
            if (con != null) {
                con.setAutoCommit(true); // 자동 커밋 복구
            }
            DBManager.close(con, pstmt);
        }
    }

    public int saveBookingDetail(Connection con, List<BookingDetail> bookingDetails, int generatedBookingId) throws java.sql.SQLException {

        PreparedStatement pstmt = null;

        int result = 0;

        try {
<<<<<<< HEAD
            con = DBManager.getConnection();
            pstmt = con.prepareStatement("INSERT INTO BOOKING(user_id, room_id, payment_date) VALUES(?,?,?)");


            pstmt.setInt(1, booking.getUserId());
            pstmt.setInt(2, booking.getRoomId());
            pstmt.setDate(3, booking.getPaymentDate());

            result = pstmt.executeUpdate();

            if(result == 0){
                System.out.println("등록되지 않았습니다. 다시 시도해주세요.");
            }else{
                System.out.println("예약이 완료되었습니다. 상세내역은 마이페이지에서 확인해주세요!");
=======
            pstmt = con.prepareStatement(
                    "INSERT INTO BOOKING_DETAIL(guest_count, room_count, total_price, check_in_date, check_out_date, payment_date, booking_id) VALUES(?, ?, ?, ?, ?, ?, ?)"
            );
            int j = 0;
            while(bookingDetails.size() > j){
                pstmt.setInt(1, bookingDetails.get(j).getGuestCount());
                pstmt.setInt(2, bookingDetails.get(j).getRoomCount());
                pstmt.setInt(3, bookingDetails.get(j).getTotalPrice());
                pstmt.setDate(4, bookingDetails.get(j).getCheckInDate());
                pstmt.setDate(5, bookingDetails.get(j).getCheckOutDate());
                pstmt.setDate(6, bookingDetails.get(j).getPaymentDate());
                pstmt.setInt(7, generatedBookingId);
                j++;
>>>>>>> feat/book
            }

            result = pstmt.executeUpdate();
            System.out.println("Booking Detail resulut = " + bookingDetails.toString());
        } finally {
            DBManager.close(null, pstmt);
        }
        return result;
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
