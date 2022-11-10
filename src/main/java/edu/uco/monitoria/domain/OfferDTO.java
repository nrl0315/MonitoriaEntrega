package edu.uco.monitoria.domain;

import java.util.UUID;
import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.monitoria.crosscuting.helper.NumberHelper.ZERO;
import static edu.uco.monitoria.domain.builder.StudentDTOBuilder.getStudentDTOBuilder;

public final class OfferDTO {
    private UUID id;
    private StudentDTO student;
    private int price;
    private String additionalInfo;

    public OfferDTO(){
        setId(getDefaultUUID(id));
        setStudent(getStudentDTOBuilder().build());
        setPrice(ZERO);
        setAdditionalInfo(EMPTY);
    }

    public OfferDTO(final UUID id, final StudentDTO student, final int price, final String additionalInfo){
        setId(getDefaultUUID(id));
        setStudent(student);
        setPrice(price);
        setAdditionalInfo(additionalInfo);
    }

    public static final OfferDTO create(final UUID id, final StudentDTO student, final int price, final String additionalInfo){
        return new OfferDTO(id,student,price,additionalInfo);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = getDefaultUUID(id);
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
