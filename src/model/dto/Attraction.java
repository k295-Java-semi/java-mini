package model.dto;

public class Attraction {
    private int attractionId;
    private String attractionName;
    private String attractionAddress;
    private String entrance;
    private String attractionImage;

    public Attraction() {}

    public Attraction(int attractionId, String attractionName, String attractionAddress, String entrance, String attractionImage) {}

    public int getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(int attractionId) {
        this.attractionId = attractionId;
    }
    public String getAttractionName() {
        return attractionName;
    }
    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public String getAttractionAddress() {
        return attractionAddress;
    }
    public void setAttractionAddress(String attractionAddress) {
        this.attractionAddress = attractionAddress;
    }
    public String getEntrance() {
        return entrance;
    }
    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getAttractionImage() {
        return attractionImage;
    }
    public void setAttractionImage(String attractionImage) {
        this.attractionImage = attractionImage;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "attractionId=" + attractionId +
                ", attractionName='" + attractionName + '\'' +
                ", attractionAddress='" + attractionAddress + '\'' +
                ", entrance='" + entrance + '\'' +
                ", attractionImage='" + attractionImage + '\'' +
                '}';
    }
}
