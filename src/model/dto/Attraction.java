package model.dto;

public class Attraction {
<<<<<<< HEAD
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
=======
	private int attraction_id;
	private String attraction_name;
	private String address;
	private boolean entrance;
	private String photo;
	
	public Attraction() {
		
	}
	
	public Attraction(int attraction_id, String attraction_name, String address, boolean entrance, String photo) {
		this.attraction_id = attraction_id;
		this.attraction_name = attraction_name;
		this.address = address;
		this.entrance = entrance;
		this.photo = photo;
	}

	public int getAttractionId() {
		return attraction_id;
	}
	public void setAttraction_id(int attraction_id) {
		this.attraction_id = attraction_id;
	}
	public String getAttractionName() {
		return attraction_name;
	}
	public void setAttractionName(String attraction_name) {
		this.attraction_name = attraction_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isEntrance() {
		return entrance;
	}
	public void setEntrance(boolean entrance) {
		this.entrance = entrance;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Attraction [attraction_id=" + attraction_id + ", attraction_name=" + attraction_name + ", address="
				+ address + ", entrance=" + entrance + ", photo=" + photo + "]";
	}
>>>>>>> develop
}
