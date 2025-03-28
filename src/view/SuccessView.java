package view;

import java.util.List;

import model.dto.Room;

public class SuccessView {

	public static void selectPrint(List<Room> list) {
//		System.out.println();
		for (Room room : list) {
			System.out.println(room);
		}
	}
	
	public static void messagePrint(String message) {
		System.out.println(message);
	}
}
