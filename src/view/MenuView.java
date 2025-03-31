package view;

import controller.*;
import model.dto.*;
import session.Session;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    private static Scanner sc = new Scanner(System.in);
    private static UserController userController = new UserController();
    private static RoomController roomController = new RoomController();
    private static BookingController bookingController = new BookingController();
    private static AttractionController attractionController = new AttractionController();
    private static RoomRateController roomRateController = new RoomRateController();
    private static AttractionRateController attractionRateController = new AttractionRateController();
	private static BookingDetailController bookingDetailController = new BookingDetailController();

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
     * 관리자 = 관리자 메뉴 
     */
    private static void printAdminMenu() {
    	while (true) {
    		System.out.println("=================관리자 전용==================");
    		System.out.println("메뉴 1. 방 관리 | 2. 관광지 관리 | 3. 로그아웃  |");
    		System.out.println("============================================");
    		System.out.print("선택 > ");
    		String choice = sc.nextLine();
    		
    		switch (choice) {
    		case "1":
    			printAdminDetailMenu();
    			break;
    			
    		case "2":
    			manageAttractions();
    			break;
    			
    		case "3":
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
     * 관리자 = 방 관리 메뉴
     */
    private static void printAdminDetailMenu() {
    	System.out.println("================================================");
		System.out.println("메뉴 1. 방 등록 | 2. 방 수정 | 3. 방 삭제 | 4. 이전으로  |");
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
			printAdminMenu();
		default:
			printError("잘못된 선택입니다.");						
		}		
    }
    
    /**
     * 관리자 = 관광지 관리 메뉴
     */
    private static void manageAttractions() {
    	while(true) {
    		System.out.println("==================================================================");
    		System.out.println("1. 관광지 추가 | 2. 관광지 조회 | 3. 관광지 수정 | 4. 관광지 삭제 | 5. 이전으로");
    		System.out.println("==================================================================");
    		System.out.print("선택 > ");
    		String choice = sc.nextLine();
    		
    		switch (choice) {
    		case "1":
    			EndAttractionView.addAttraction();
    			break;
    		case "2":
    			EndAttractionView.viewAttractionById();
    			break;
    		case "3":
    			EndAttractionView.updateAttraction();
    			break;
    		case "4":
    			EndAttractionView.deleteAttraction();
    			break;
    		
    		case "5":
    			printAdminMenu();
    		default:
    			printError("잘못된 선택입니다.");
    		}    		
    	}
    }

    /**
     * 권한 = guest에게 보여주는 메뉴
     */
    private static void printUserMenu() {
    	while(true) {
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
					makeReservation();
					break;
				case "3":
    			viewAttractions();
    			break;
    		case "4":
    			viewDirections();
    			break;
    		case "5":
    			viewMyPage();
    			break;
    		case "6":
    			System.out.println("프로그램을 종료합니다.");
    			System.exit(0);
    			break;
    		default:
    			printError("잘못된 선택입니다.");
    		}    		
    	}
    }

    /**
     * 
     * 모든 방 조회
     */
    private static void viewRooms() {
        try {
           List<Room> rooms = roomController.getAllRooms();
            System.out.println("---------------------------------------------------------");
            System.out.printf("| %-6s| %-7s| %-4s| %-5s| %-11s| %-7s| %-5s |\n",
                    "방 아이디", "방 번호", "타입", "크기", "가격", "인원 수", "상태");
            System.out.println("---------------------------------------------------------");
            
            NumberFormat currencyFormat = NumberFormat.getInstance();
            for (Room room : rooms) {
               String availability = room.isAvailable() ? "에약 가능" : "예약 중";
               
               String sizeIn = convertSizeTo(room.getSize());
               
               System.out.printf("| %-7d | %-7s | %-4s | %-5s | %-11s | %-7d | %-9s |\n",
                     room.getRoomId(),
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


	private static void makeReservation() {
		try {
			List<Room> rooms = roomController.getAllRooms();
			System.out.println("예약 가능한 방 목록:");
			System.out.println("----------------------------------------------------------");
			System.out.printf("| %-7s | %-5s | %-4s | %-9s | %-7s | %-7s |\n", "방 번호", "타입", "크기", "가격", "인원 수", "상태");
			System.out.println("----------------------------------------------------------");
			for (Room room : rooms) {
				String status = room.isAvailable() ? "예약 가능" : "예약 중";
				System.out.printf("| %-7s | %-5s | %-4s | %,9d | %-7d | %-7s |\n",
						room.getRoomNumber(), room.getType(), room.getSize(), (int) room.getPrice(), room.getCapacity(), status);
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("1. 예약하기  |  2. 나가기");
			System.out.println("==================");
			System.out.print("선택 > ");
			String choice = sc.nextLine();

			if ("1".equals(choice)) {
				System.out.print("예약할 방 번호를 입력해주세요: ");
				String roomNumber = sc.nextLine();
				Room selectedRoom = rooms.stream()
						.filter(r -> r.getRoomNumber().equals(roomNumber) && r.isAvailable())
						.findFirst()
						.orElse(null);
				if (selectedRoom == null) {
					printError("유효하지 않거나 예약 불가능한 방입니다.");
					return;
				}

				System.out.print("사용자 ID를 입력해주세요: "); // Ask for user ID
				int userId = Integer.parseInt(sc.nextLine());
				System.out.print("인원수를 입력해주세요: ");
				int guestCount = Integer.parseInt(sc.nextLine());
				System.out.print("예약일을 입력해주세요(YYYY-MM-DD): ");
				Date paymentDate = Date.valueOf(sc.nextLine());


				Booking booking = new Booking(userId, guestCount, paymentDate);
				bookingController.addBooking(booking);
				System.out.println("=================================");
				System.out.println("예약이 완료되었습니다.");
			}
		} catch (Exception e) {
			printError(e.getMessage());
		}
	}


	private static void viewAttractions() {
        try {
            List<Attraction> attractions = attractionController.selectAllAttractions();
            System.out.println("관광지 목록:");
            System.out.println("----------------------------------------------------------");
            System.out.printf("| %-11s | %-20s | %-50s | %-8s |\n", "ID", "이름", "주소", "입장 여부");
            System.out.println("----------------------------------------------------------");
            for (Attraction attraction : attractions) {
                System.out.printf("| %-11d | %-20s | %-50s | %-8s |\n",
                    attraction.getAttractionId(), attraction.getAttractionName(), attraction.getAddress(),
                    attraction.isEntrance() ? "가능" : "불가");
            }
            System.out.println("----------------------------------------------------------");
        } catch (Exception e) {
            printError(e.getMessage());
        }
    }

    private static void viewDirections() {
        System.out.println("오시는 길: 라비에뜨 펜션 - 대부도 어딘가 (임시 주소)");
    }

	private static void viewMyPage() {
		while (true) {
			Session session = userController.getInstance().getSession();
			System.out.println("[마이페이지]");
			System.out.println(userController.userInfo(session.getUserId()));
			System.out.println("=========================================================================");
			System.out.println("1. 예약 내역 | 2. 회원 정보 수정 | 3. 방 평점 관리 | 4. 관광지 평점 관리 | 5. 회원탈퇴 |");
			System.out.println("=========================================================================");
			System.out.print("선택 > ");
			String choice = sc.nextLine();

			switch (choice) {
				case "1":
					viewBookingHistory();
					break;
				case "2":
					EndUserView.updateUserInfo();
					break;
				case "3":
					manageRoomRates();
					break;
				case "4":
					manageAttractionRates();
					break;

				case "5":
					EndUserView.deleteUser();
					printLoginMenu();
					return;
				default:
					printError("잘못된 선택입니다.");
			}
		}
	}

	private static void viewBookingHistory() {
		try {
			Session session = userController.getInstance().getSession();
			int userId = Integer.parseInt(String.valueOf(session.getUserId()));

			List<Booking> bookings = bookingController.getBookingById(userId);
			System.out.println("----------------------------------------------------------");
			System.out.printf("| %-9s | %-7s | %-11s | %-12s | %-6s | %-6s | %-9s |\n", "예약 번호", "방 번호", "체크인 날짜", "체크아웃 날짜", "인원수", "가격", "예약 상태");
			System.out.println("----------------------------------------------------------");
			for (Booking booking : bookings) {
				Room room = roomController.getRoomById(booking.getRoomId());
				BookingDetail detail = bookingDetailController.getBookingDetailById(booking.getBookingDetailId());
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
				viewBookingHistory();
			}
		} catch (Exception e) {
			printError(e.getMessage());
		}
	}

	private static void deleteBookingDetail(int bookingDetailId, Booking Booking) {
		try {
			bookingDetailController.deleteBookingDetail(bookingDetailId);
			System.out.println("예약 상세가 삭제되었습니다.");
		} catch (Exception e) {
			printError("예약 상세 삭제 중 오류 발생: " + e.getMessage());
		}
		System.out.print("예약 번호를 입력해주세요: ");
		int bookingId = Integer.parseInt(sc.nextLine());
		try {
			BookingDetail booking = bookingDetailController.getBookingDetailById(bookingId);
			int userId = booking.getUser().getUserId();
			if (booking == null || booking.getUser().getUserId() != userId) {
				printError("유효하지 않은 예약 번호입니다.");
				return;
			}
			Room room = roomController.getRoomById(booking.getRoom().getRoomId());
			BookingDetail detail = bookingDetailController.getBookingDetailById(booking.getBookingDetailId());

			System.out.println("--------------------------------");
			System.out.println("예약 상세:");
			System.out.println("---------------------------------------");
			System.out.printf("| %-8s | %-15s |\n", "방 번호", room.getRoomNumber());
			System.out.printf("| %-8s | %-15s |\n", "체크인", detail.getCheckInDate());
			System.out.printf("| %-8s | %-15s |\n", "체크아웃", detail.getCheckOutDate());
			System.out.printf("| %-8s | %-15d |\n", "인원수", detail.getGuestCount());
			System.out.printf("| %-8s | %,15d원 |\n", "총 가격", (int) detail.getTotalPrice());
			System.out.println("---------------------------------------");
			System.out.println("1. 예약 수정 | 2. 예약 취소 | 3. 예약 상세 삭제 | 0. 나가기");
			System.out.print("선택 > ");
			String choice = sc.nextLine();

			switch (choice) {
				case "1":
					bookingController.updateBooking(bookingId, Booking);
					break;
				case "2":
					bookingController.cancelBooking(booking.getBookingDetailId());
					break;
				case "3":
					deleteBookingDetail(booking.getBookingDetailId(), Booking);
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

    private static void manageRoomRates() {
        while (true) {
            System.out.println("1. 평점 추가 | 2. 전체 평점 조회 | 3. 평점 조회 | 4. 평점 수정 | 5. 평점 삭제 |");
            System.out.print("선택 > ");
            String choice = sc.nextLine();
    
            switch (choice) {
                case "1":
                    EndRoomRateView.addRoomRate();
                    break;
                case "2":
                	EndRoomRateView.selectAllRoomRates();
                   break;
                case "3":
                	EndRoomRateView.viewRoomRatesById();
                    break;
                case "4":
                	EndRoomRateView.updateRoomRate();
                    break;
                case "5":
                	EndRoomRateView.deleteRoomRate();
                    break;     
                default:
                    printError("잘못된 선택입니다.");
            }
        }
     }

     private static void manageAttractionRates() {
        while (true) {
            System.out.println("1. 평점 추가 | 2. 평점 조회 | 3. 평균 평점 조회 | 4. 평점 수정 | 5. 평점 삭제 |");
            System.out.print("선택 > ");
            String choice = sc.nextLine();
    
            switch (choice) {
                case "1":
                    EndAttractionRateView.addAttractionRate();
                    break;
                case "2":
                	EndAttractionRateView.viewAttractionRatesById();
                    break;
                case "3":
                	EndAttractionRateView.viewAttractionAverageScore();
                    break;
                case "4":
                	EndAttractionRateView.updateAttractionRate();
                    break;
                case "5":
                	EndAttractionRateView.deleteAttractionRate();
                    break;
                default:
                    printError("잘못된 선택입니다.");
            }
        }
     }

    public static void printError(String message) {
        System.out.println("오류: " + message);
    }
}