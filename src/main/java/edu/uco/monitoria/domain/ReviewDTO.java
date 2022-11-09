package edu.uco.monitoria.domain;

import java.util.UUID;
import static edu.uco.monitoria.crosscuting.helper.NumberHelper.DECIMAL_ZERO;
import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.monitoria.crosscuting.helper.NumberHelper.ZERO;

public final class ReviewDTO {
    private UUID id;
    private double starRate;
    private String comment;

    public ReviewDTO(){
        setId(getDefaultUUID(id));
        setStarRate(DECIMAL_ZERO);
        setComment(EMPTY);
    }

    public ReviewDTO(UUID id, double starRate, String comment) {
        setId(getDefaultUUID(id));
        setStarRate(starRate);
        setComment(comment);
    }

    public static final ReviewDTO create(final UUID id, final double starRate, final String comment){
        return new ReviewDTO(id,starRate,comment);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getStarRate() {
        return starRate;
    }

    public void setStarRate(double starRate) {
        this.starRate = starRate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
