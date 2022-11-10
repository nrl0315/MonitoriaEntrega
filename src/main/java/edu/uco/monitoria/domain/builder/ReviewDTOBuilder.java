package edu.uco.monitoria.domain.builder;

import edu.uco.monitoria.domain.ReviewDTO;

import java.util.UUID;

public final class ReviewDTOBuilder {
    private UUID id;
    private double starRate;
    private String comment;

    private ReviewDTOBuilder(){
        super();
    }

    public static final ReviewDTOBuilder getReviewDTOBuilder(){
        return new ReviewDTOBuilder();
    }

    public final ReviewDTOBuilder setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final ReviewDTOBuilder setStarRate(final double starRate) {
        this.starRate = starRate;
        return this;
    }

    public final ReviewDTOBuilder setComment(final String comment) {
        this.comment = comment;
        return this;
    }

    public final ReviewDTO build(){
        return ReviewDTO.create(id,starRate,comment);
    }
}
