package view;

import java.util.Scanner;

import controller.RoomController;
import model.dto.Room;

public class EndRoomView {

	private static Scanner sc = new Scanner(System.in);
	
	/**
     * 방 등록
     */
    public static void newRoom() {
    	
    	System.out.print("방 번호 : ");
        String roomNumber = sc.nextLine();
        System.out.print("방 타입 : ");
        String type = sc.nextLine();
        System.out.print("가격 입력:");
        int price = Integer.parseInt(sc.nextLine());
        System.out.print("수용 인원 입력:");
        int capacity = Integer.parseInt(sc.nextLine());
        System.out.print("크기 입력:");
        String size = sc.nextLine();
        System.out.print("설명 입력:");
        String description = sc.nextLine();
    	
    	Room room = new Room(roomNumber, type, price, capacity, size, description);   
        
        RoomController.getInstance().addRoom(room);      
    }
    
    /**
     * 방 수정
     */
    public static void updateRoom() {
    	System.out.print("수정할 방 Id : ");
   	    int roomId = Integer.parseInt(sc.nextLine());
	   	System.out.print("방 번호 : ");
	    String roomNumber = sc.nextLine();
	    System.out.print("방 타입 : ");
	    String type = sc.nextLine();
	    System.out.print("가격 입력:");
	    int price = Integer.parseInt(sc.nextLine());
	    System.out.print("수용 인원 입력:");
	    int capacity = Integer.parseInt(sc.nextLine());
	    System.out.print("크기 입력:");
	    String size = sc.nextLine();
	    System.out.print("설명 입력:");
	    String description = sc.nextLine();
    	
    	Room room = new Room(roomId, roomNumber, type, price, capacity, size, description, true);
        
        RoomController.getInstance().updateRoom(room);     
    }
    
    /**
     * 방 삭제
     */
    public static void deleteRoom() {
    	System.out.print("삭제할 방 Id : ");
    	int roomId = Integer.parseInt(sc.nextLine());
    	RoomController.getInstance().deleteRoom(roomId);;
    }
}
