package view;

import controller.*;
import model.dto.*;
import pension.exception.NotFoundException;
import session.Session;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    private static Scanner sc = new Scanner(System.in);
    private static UserController userController = new UserController();
    private static RoomController roomController = new RoomController();
    private static BookingController bookingController = new BookingController();
//    private static AttractionController attractionController = new AttractionController();
    private static RoomRateController roomRateController = new RoomRateController();
    private static AttractionRateController attractionRateController = new AttractionRateController();

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("\"라비에뜨 펜션 (La Viette,  ‘작은 삶의 기쁨’) 에 온 것을 환영합니다\"");
        System.out.println("==============================================");
        
        boolean loggedIn = false;
        
        while (true) {
        	if (!loggedIn) {
        		loggedIn = printLoginMenu();        		
        	}
        }
    }
    
    /**
     * 처음 메뉴
     */
    private static boolean printLoginMenu() {
    	System.out.println("==============================================");
        System.out.println("메뉴 1. 회원가입 | 2. 로그인 | 3. 종료");
        System.out.println("==============================================");
        System.out.print("선택 > ");
        String choice = sc.nextLine();
        
        switch (choice) {
        case "1":
        	EndUserView.newRegister();
        	break;
        case "2":
        	boolean loginSuccess = false;
        	
        	try {
        		loginSuccess = EndUserView.userLogin();
        		
        	} catch (Exception e) {
        		System.out.println(e.getMessage());
        	}
        	
        	if (loginSuccess) {
        		Session session = UserController.getInstance().getSession();
        		String role = session.getRole();
        		
        		if ("admin".equals(role)) {
        			printAdminMenu();
        			return true;
        		} else {
        			printUserMenu();
        			return true;
        		}
        		
        	}
        	break;
        	
        case "3":
        	System.out.println("프로그램 종료합니다.");
        	System.exit(0);
        default:
        	printError("잘못된 선택입니다.");
        }
        return false;
    }
    
    
    
    /**
     * 권한 = admin에게 보여주는 메뉴
     */
    private static void printAdminMenu() {
    	while (true) {
    		System.out.println("================================================");
    		System.out.println("메뉴 1. 방 등록 | 2. 방 수정 | 3. 방 삭제 | 4. 로그아웃  |");
    		System.out.println("================================================");
    		System.out.print("선택 > ");
    		String choice = sc.nextLine();
    		
    		switch (choice) {
    		case "1":
    			EndRoomView.newRoom();
    			break;
    			
    		case "2":
    			EndRoomView.updateRoom();
    			break;
    		case "3":
    			EndRoomView.deleteRoom();
    			break;
    			
    		case "4":
    			Session session = UserController.getInstance().getSession();
    			System.out.println("로그아웃");
    			System.out.println(session);
    			printLoginMenu();
    			return;
    		default:
    			printError("잘못된 선택입니다.");
    			
    		}
    	}
    }

    /**
     * 권한 = guest에게 보여주는 메뉴
     */
    private static void printUserMenu() {
        System.out.println("==============================================");
        System.out.println("메뉴 1. 방 소개 | 2. 예약하기 | 3. 관광지 소개 | 4. 오시는 길 | 5. 마이페이지 | 6. 종료");
        System.out.println("==============================================");
        System.out.print("선택 > ");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                viewRooms();
                break;
            case "2":
                //makeReservation();
                break;
            case "3":
//                viewAttractions();
                break;
            case "4":
//                viewDirections();
                break;
            case "5":
//                viewMyPage();
                break;
            case "6":
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
                break;
            default:
                printError("잘못된 선택입니다.");
        }
    }

    /**
     * 모든 방 조회
     */
    private static void viewRooms() {
        try {
            List<Room> rooms = roomController.getAllRooms();
            System.out.println("--------------------------------------");
            System.out.println("| 방 번호 | 타입 | 크기   |    가격    | 인원 수 | 상태  |");
            System.out.println("--------------------------------------");
            
            NumberFormat currencyFormat = NumberFormat.getInstance();
            for (Room room : rooms) {
            	String availability = room.isAvailable() ? "에약 가능" : "예약 중";
            	
            	String sizeIn = convertSizeTo(room.getSize());
            	
            	System.out.printf("| %-5s | %-3s | %-4s | %-10s | %-4d | %-5s |\n",
                        room.getRoomNumber(),
                        room.getType(),
                        sizeIn,
                        currencyFormat.format(room.getPrice()),  // 천 단위 쉼표 추가
                        room.getCapacity(),
                        availability);
            }
        } catch (Exception e) {
            printError(e.getMessage());
        }
    }
    
    /**
     * 방 평수 계산 메서드
     */
    private static String convertSizeTo(String size) {
    	int sizeIn = Integer.parseInt(size);
    	double sizeInP = sizeIn / 3.3;
    	return String.format("%.0f평", sizeInP);
    }

//    private static void makeReservation() {
//        try {
//            List<Room> rooms = roomController.selectAllRooms();
//            System.out.println("예약 가능한 방 목록:");
//            System.out.println("----------------------------------------------------------");
//            System.out.printf("| %-7s | %-5s | %-4s | %-9s | %-7s | %-7s |\n", "방 번호", "타입", "크기", "가격", "인원 수", "상태");
//            System.out.println("----------------------------------------------------------");
//            for (Room room : rooms) {
//                String status = bookingController.isRoomAvailable(room.getRoomId()) ? "예약 가능" : "예약 중";
//                System.out.printf("| %-7s | %-5s | %-4s | %,9d | %-7d | %-7s |\n",
//                    room.getRoomNumber(), room.getType(), room.getSize(), (int) room.getPrice(), room.getCapacity(), status);
//            }
//            System.out.println("----------------------------------------------------------");
//            System.out.println("1. 예약하기  |  2. 나가기");
//            System.out.println("==================");
//            System.out.print("선택 > ");
//            String choice = sc.nextLine();
//
//            if ("1".equals(choice)) {
//                System.out.print("예약할 방 번호를 입력해주세요: ");
//                String roomNumber = sc.nextLine();
//                Room selectedRoom = rooms.stream()
//                    .filter(r -> r.getRoomNumber().equals(roomNumber))
//                    .findFirst()
//                    .orElse(null);
//                if (selectedRoom == null || !bookingController.isRoomAvailable(selectedRoom.getRoomId())) {
//                    printError("유효하지 않거나 예약 불가능한 방입니다.");
//                    return;
//                }
//
//                System.out.print("사용자 ID를 입력해주세요: "); // 사용자 ID 입력 추가
//                String userId = sc.nextLine();
//                System.out.print("인원수를 입력해주세요: ");
//                int guestCount = Integer.parseInt(sc.nextLine());
//                System.out.print("체크인 날짜를 입력해주세요(YYYY-MM-DD): ");
//                String checkIn = sc.nextLine();
//                System.out.print("체크아웃 날짜를 입력해주세요(YYYY-MM-DD): ");
//                String checkOut = sc.nextLine();
//
//                Booking booking = new Booking(0, userId, selectedRoom.getRoomId(), null, 0);
//                bookingController.insertBooking(booking, checkIn, checkOut);
//                System.out.println("=================================");
//                System.out.println("예약이 완료되었습니다.");
//            }
//        } catch (Exception e) {
//            printError(e.getMessage());
//        }
//    }
    

//    private static void viewAttractions() {
//        try {
//            List<Attraction> attractions = attractionController.selectAllAttractions();
//            System.out.println("관광지 목록:");
//            System.out.println("----------------------------------------------------------");
//            System.out.printf("| %-11s | %-20s | %-50s | %-8s |\n", "ID", "이름", "주소", "입장 여부");
//            System.out.println("----------------------------------------------------------");
//            for (Attraction attraction : attractions) {
//                System.out.printf("| %-11d | %-20s | %-50s | %-8s |\n",
//                    attraction.getAttractionId(), attraction.getAttractionName(), attraction.getAddress(),
//                    attraction.isEntrance() ? "가능" : "불가");
//            }
//            System.out.println("----------------------------------------------------------");
//        } catch (Exception e) {
//            printError(e.getMessage());
//        }
//    }
//
//    private static void viewDirections() {
//        System.out.println("오시는 길: 라비에뜨 펜션 - 대부도 어딘가 (임시 주소)");
//    }

//    private static void viewMyPage() {
//        System.out.println("[마이페이지]");
//        System.out.println("===============================");
//        System.out.println("1. 예약 내역 | 2. 방 평점 관리 | 3. 관광지 평점 관리 | 4. 관광지 관리 (관리자용)");
//        System.out.print("선택 > ");
//        String choice = sc.nextLine();
//
//        switch (choice) {
//            case "1":
//                // viewBookingHistory();
//                break;
//            case "2":
//                manageRoomRates();
//                break;
//            case "3":
////                manageAttractionRates();
//                break;
//            case "4":
////                manageAttractions(); // 관리자 체크 제거 또는 별도 입력으로 대체 가능
//                break;
//            default:
//                printError("잘못된 선택입니다.");
//        }
//    }

    /**
    private static void viewBookingHistory() {
        try {
            System.out.print("사용자 ID를 입력해주세요: ");
            String userId = sc.nextLine();
            List<Booking> bookings = bookingController.selectBookingsByUserId(userId);
            System.out.println("----------------------------------------------------------");
            System.out.printf("| %-9s | %-7s | %-11s | %-12s | %-6s | %-6s | %-9s |\n", "예약 번호", "방 번호", "체크인 날짜", "체크아웃 날짜", "인원수", "가격", "예약 상태");
            System.out.println("----------------------------------------------------------");
            for (Booking booking : bookings) {
                Room room = roomController.selectRoomById(booking.getRoomId());
                BookingDetail detail = bookingController.getBookingDetail(booking.getBookingDetailId());
                System.out.printf("| %-9d | %-7s | %-11s | %-12s | %-6d | %,6d | %-9s |\n",
                    booking.getBookingId(), room.getRoomNumber(), detail.getCheckInDate(), detail.getCheckOutDate(),
                    detail.getGuestCount(), (int) detail.getTotalPrice(), "완료");
            }
            System.out.println("----------------------------------------------------------");
            System.out.println("0. 메뉴로 나가기 | 1. 예약 번호 상세 보기");
            System.out.println("--------------------------------------------");
            System.out.print("선택 > ");
            String choice = sc.nextLine();

            if ("1".equals(choice)) {
                viewBookingDetail(userId);
            }
        } catch (Exception e) {
            printError(e.getMessage());
        }
    }

    private static void viewBookingDetail(String userId) {
        System.out.print("예약 번호를 입력해주세요: ");
        int bookingId = Integer.parseInt(sc.nextLine());
        try {
            Booking booking = bookingController.selectBookingById(bookingId);
            if (booking == null || !booking.getUserId().equals(userId)) {
                printError("유효하지 않은 예약 번호입니다.");
                return;
            }
            Room room = roomController.selectRoomById(booking.getRoomId());
            BookingDetail detail = bookingController.getBookingDetail(booking.getBookingDetailId());

            System.out.println("--------------------------------");
            System.out.println("예약 상세:");
            System.out.println("---------------------------------------");
            System.out.printf("| %-8s | %-15s |\n", "방 번호", room.getRoomNumber());
            System.out.printf("| %-8s | %-15s |\n", "체크인", detail.getCheckInDate());
            System.out.printf("| %-8s | %-15s |\n", "체크아웃", detail.getCheckOutDate());
            System.out.printf("| %-8s | %-15d |\n", "인원수", detail.getGuestCount());
            System.out.printf("| %-8s | %,15d원 |\n", "총 가격", (int) detail.getTotalPrice());
            System.out.println("---------------------------------------");
            System.out.println("1. 예약 수정 | 2. 예약 취소 | 0. 나가기");
            System.out.print("선택 > ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    updateBooking(booking);
                    break;
                case "2":
                    cancelBooking(booking.getBookingId());
                    break;
                case "0":
                    break;
                default:
                    printError("잘못된 선택입니다.");
            }
        } catch (Exception e) {
            printError(e.getMessage());
        }
    }

    private static void updateBooking(Booking booking) {
        System.out.print("새 체크인 날짜(YYYY-MM-DD): ");
        String checkIn = sc.nextLine();
        System.out.print("새 체크아웃 날짜(YYYY-MM-DD): ");
        String checkOut = sc.nextLine();
        try {
            bookingController.updateBooking(booking, checkIn, checkOut);
            System.out.println("예약이 수정되었습니다.");
        } catch (Exception e) {
            printError(e.getMessage());
        }
    }

    private static void cancelBooking(int bookingId) {
        try {
            bookingController.deleteBooking(bookingId);
            System.out.println("예약이 취소되었습니다.");
        } catch (Exception e) {
            printError(e.getMessage());
        }
    }
    **/

//    private static void manageRoomRates() {
//        System.out.println("1. 평점 추가 | 2. 평점 조회 | 3. 평균 평점 조회 | 4. 평점 수정 | 5. 평점 삭제 | 6. 상위 평점 방 조회");
//        System.out.print("선택 > ");
//        String choice = sc.nextLine();
//
//        switch (choice) {
//            case "1":
//                addRoomRate();
//                break;
//            case "2":
//                viewRoomRatesById();
//                break;
//            case "3":
//                // viewRoomAverageScore();
//                break;
//            case "4":
//                updateRoomRate();
//                break;
//            case "5":
//                deleteRoomRate();
//                break;
//            default:
//                printError("잘못된 선택입니다.");
//        }
//    }
//
//    private static void manageAttractionRates() {
//        System.out.println("1. 평점 추가 | 2. 평점 조회 | 3. 평균 평점 조회 | 4. 평점 수정 | 5. 평점 삭제 | 6. 상위 평점 관광지 조회");
//        System.out.print("선택 > ");
//        String choice = sc.nextLine();
//
//        switch (choice) {
//            case "1":
//                addAttractionRate();
//                break;
//            case "2":
//                viewAttractionRatesById();
//                break;
//            case "3":
//                viewAttractionAverageScore();
//                break;
//            case "4":
//                updateAttractionRate();
//                break;
//            case "5":
//                deleteAttractionRate();
//                break;
//            default:
//                printError("잘못된 선택입니다.");
//        }
//    }
//
//    private static void manageAttractions() {
//        System.out.println("1. 관광지 추가 | 2. 관광지 조회 | 3. 관광지 수정 | 4. 관광지 삭제");
//        System.out.print("선택 > ");
//        String choice = sc.nextLine();
//
//        switch (choice) {
//            case "1":
//                addAttraction();
//                break;
//            case "2":
//                viewAttractionById();
//                break;
//            case "3":
//                updateAttraction();
//                break;
//            case "4":
//                deleteAttraction();
//                break;
//            default:
//                printError("잘못된 선택입니다.");
//        }
//    }
//
//    private static void addRoomRate() {
//        System.out.print("사용자 ID를 입력해주세요: ");
//        String userId = sc.nextLine();
//        System.out.print("평점을 추가할 방 번호(room_id): ");
//        int roomId = Integer.parseInt(sc.nextLine());
//        System.out.print("평점(1-5): ");
//        int score = Integer.parseInt(sc.nextLine());
//        System.out.print("코멘트: ");
//        String comment = sc.nextLine();
//        roomRateController.addRoomRate(userId, roomId, score, comment);
//    }
//
//    private static void viewRoomRatesById() {
//        System.out.print("조회할 평점 ID(roomrate_id): ");
//        int roomRateId = Integer.parseInt(sc.nextLine());
//        roomRateController.viewRoomRates(roomRateId);
//    }
//
//
//    private static void updateRoomRate() {
//        System.out.print("수정할 평점 ID(roomrate_id): ");
//        int roomRateId = Integer.parseInt(sc.nextLine());
//        System.out.print("새 평점(1-5): ");
//        int score = Integer.parseInt(sc.nextLine());
//        System.out.print("새 코멘트: ");
//        String comment = sc.nextLine();
//        System.out.print("공개 여부(true/false): ");
//        boolean visible = Boolean.parseBoolean(sc.nextLine());
//        roomRateController.updateRoomRate(roomRateId, score, comment, visible);
//    }
//
//    private static void deleteRoomRate() {
//        System.out.print("삭제할 평점 ID(roomrate_id): ");
//        int roomRateId = Integer.parseInt(sc.nextLine());
//        roomRateController.deleteRoomRate(roomRateId);
//    }
//
//
//
//    private static void addAttractionRate() {
//        System.out.print("사용자 ID를 입력해주세요: ");
//        String userId = sc.nextLine();
//        System.out.print("평점을 추가할 관광지 번호(attraction_id): ");
//        int attractionId = Integer.parseInt(sc.nextLine());
//        System.out.print("평점(1-5): ");
//        int score = Integer.parseInt(sc.nextLine());
//        System.out.print("코멘트: ");
//        String comment = sc.nextLine();
//        attractionRateController.addAttractionRate(userId, attractionId, score, comment);
//    }
//
//    private static void viewAttractionRatesById() {
//        System.out.print("조회할 평점 ID(attractionrate_id): ");
//        int attractionRateId = Integer.parseInt(sc.nextLine());
//        attractionRateController.viewAttractionRateById(attractionRateId);
//    }
//
//    private static void viewAttractionAverageScore() {
//        System.out.print("조회할 관광지 번호(attraction_id): ");
//        int attractionId = Integer.parseInt(sc.nextLine());
//        attractionRateController.viewAttractionRateById(attractionId);
//    }
//
//    private static void updateAttractionRate() {
//        System.out.print("수정할 평점 ID(attractionrate_id): ");
//        int attractionRateId = Integer.parseInt(sc.nextLine());
//        System.out.print("새 평점(1-5): ");
//        int score = Integer.parseInt(sc.nextLine());
//        System.out.print("새 코멘트: ");
//        String comment = sc.nextLine();
//        attractionRateController.updateAttractionRate(attractionRateId, score, comment);
//    }
//
//    private static void deleteAttractionRate() {
//        System.out.print("삭제할 평점 ID(attractionrate_id): ");
//        int attractionRateId = Integer.parseInt(sc.nextLine());
//        attractionRateController.deleteAttractionRate(attractionRateId);
//    }
//
//
//    private static void addAttraction() {
//        System.out.print("관광지 이름: ");
//        String name = sc.nextLine();
//        System.out.print("주소: ");
//        String address = sc.nextLine();
//        System.out.print("입장 가능 여부(true/false): ");
//        boolean entrance = Boolean.parseBoolean(sc.nextLine());
//        System.out.print("사진 파일명: ");
//        String photo = sc.nextLine();
//        attractionController.addAttraction(name, address, entrance, photo);
//    }
//
//    private static void viewAttractionById() {
//        System.out.print("조회할 관광지 ID(attraction_id): ");
//        int attractionId = Integer.parseInt(sc.nextLine());
//        try {
//            Attraction attraction = attractionController.selectAttractionById(attractionId);
//            if (attraction != null) {
//                System.out.println("----------------------------------------------------------");
//                System.out.printf("| %-11s | %-20s | %-50s | %-8s |\n", "ID", "이름", "주소", "입장 여부");
//                System.out.println("----------------------------------------------------------");
//                System.out.printf("| %-11d | %-20s | %-50s | %-8s |\n",
//                    attraction.getAttractionId(), attraction.getAttractionName(), attraction.getAddress(),
//                    attraction.isEntrance() ? "가능" : "불가");
//                System.out.println("----------------------------------------------------------");
//            } else {
//                printError("해당 관광지가 존재하지 않습니다.");
//            }
//        } catch (Exception e) {
//            printError(e.getMessage());
//        }
//    }
//
//    private static void updateAttraction() {
//        System.out.print("수정할 관광지 ID(attraction_id): ");
//        int attractionId = Integer.parseInt(sc.nextLine());
//        System.out.print("새 이름: ");
//        String name = sc.nextLine();
//        System.out.print("새 주소: ");
//        String address = sc.nextLine();
//        System.out.print("새 입장 가능 여부(true/false): ");
//        boolean entrance = Boolean.parseBoolean(sc.nextLine());
//        System.out.print("새 사진 파일명: ");
//        String photo = sc.nextLine();
//        attractionController.updateAttraction(attractionId, name, address, entrance, photo);
//    }
//
//    private static void deleteAttraction() {
//        System.out.print("삭제할 관광지 ID(attraction_id): ");
//        int attractionId = Integer.parseInt(sc.nextLine());
//        attractionController.deleteAttraction(attractionId);
//    }
//
    public static void printError(String message) {
        System.out.println("오류: " + message);
    }
}