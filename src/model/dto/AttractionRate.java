package model.dto;

public class AttractionRate {
    private int attractionRateId;
    private int attractionScore;
    private String comment;
    private int attractionId;

    public AttractionRate(int attractionRateId, int attractionScore, String comment, int attractionId) {
        this.attractionRateId = attractionRateId;
        this.attractionScore = attractionScore;
        this.comment = comment;
        this.attractionId = attractionId;
    }

    public int getAttractionRateId() {
        return attractionRateId;
    }

    public void setAttractionRateId(int attractionRateId) {
        this.attractionRateId = attractionRateId;
    }

    public int getAttractionScore() {
        return attractionScore;
    }

    public void setAttractionScore(int attractionScore) {
        this.attractionScore = attractionScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(int attractionId) {
        this.attractionId = attractionId;
    }

    @Override
    public String toString() {
        return "AttractionRate{" +
                "attractionRateId=" + attractionRateId +
                ", attractionScore=" + attractionScore +
                ", comment='" + comment + '\'' +
                ", attractionId=" + attractionId +
                '}';
    }
}