package model.dto;

public class Room {
    private int roomId;
    private String roomNumber;
    private String type;
    private int price;
    private int capacity;
    private String size;
    private String description;
    private boolean available = true;
    
    public Room() {}

    public Room(String roomNumber, String type, int price, int capacity, String size, String description) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.capacity = capacity;
        this.size = size;
        this.description = description;
        this.available = true;
    }
    
    public Room(int roomId, String roomNumber, String type, int price, int capcity, String size, String description, boolean available) {
    	this(roomNumber, type, price, capcity, size, description);
    	this.roomId = roomId;
    	this.available = available;
    }
    
    

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber='" + roomNumber + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}