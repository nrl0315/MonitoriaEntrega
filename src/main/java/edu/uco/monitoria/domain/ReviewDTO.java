package edu.uco.monitoria.domain;

import edu.uco.monitoria.crosscuting.helper.UUIDHelper;

import java.util.UUID;
import static edu.uco.monitoria.crosscuting.helper.NumberHelper.DECIMAL_ZERO;
import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.monitoria.crosscuting.helper.NumberHelper.ZERO;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getUUIDFromString;
import static edu.uco.monitoria.domain.builder.StudentDTOBuilder.getStudentDTOBuilder;

public final class ReviewDTO {
    private StudentDTO student;
    private UUID id;
    private double starRate;
    private String comment;

    public ReviewDTO(){
        setId(getDefaultUUID(id));
        setStarRate(DECIMAL_ZERO);
        setComment(EMPTY);
        setStudent(getStudentDTOBuilder().build());
    }

    public ReviewDTO(UUID id, double starRate, String comment,StudentDTO student) {
        setId(getDefaultUUID(id));
        setStarRate(starRate);
        setComment(comment);
        setStudent(student);
    }

    public static final ReviewDTO create(final UUID id, final double starRate, final String comment, final StudentDTO student){
        return new ReviewDTO(id,starRate,comment,student);
    }

    public static final ReviewDTO create(final String id,final double starRate, final String comment, final StudentDTO student ){
        return new ReviewDTO(getUUIDFromString(id),starRate,comment,student);
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = getDefaultUUID(id);
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

    public final String getUUIDAsString(){
        return UUIDHelper.getUUIDAsString(getId());
    }
}
