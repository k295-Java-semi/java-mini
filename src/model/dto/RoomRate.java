package model.dto;

public class RoomRate {
    private int roomRateId;
    private int roomScore;
    private String comment;
    private boolean visible;
    private int roomId;

    public RoomRate(int roomRateId, int roomScore, String comment, boolean visible, int roomId) {
        this.roomRateId = roomRateId;
        this.roomScore = roomScore;
        this.comment = comment;
        this.visible = visible;
        this.roomId = roomId;
    }

    public int getRoomRateId() {
        return roomRateId;
    }

    public void setRoomRateId(int roomRateId) {
        this.roomRateId = roomRateId;
    }

    public int getRoomScore() {
        return roomScore;
    }

    public void setRoomScore(int roomScore) {
        this.roomScore = roomScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "RoomRate{" +
                "roomRateId=" + roomRateId +
                ", roomScore=" + roomScore +
                ", comment='" + comment + '\'' +
                ", visible=" + visible +
                ", roomId=" + roomId +
                '}';
    }
}