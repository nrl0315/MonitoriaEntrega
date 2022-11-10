package edu.uco.monitoria.domain.builder;

import edu.uco.monitoria.domain.OfferDTO;
import edu.uco.monitoria.domain.StudentDTO;

import java.util.UUID;

public final class OfferDTOBuilder {
    private UUID id;
    private StudentDTO student;
    private int price;
    private String additionalInfo;

    private OfferDTOBuilder(){
        super();
    }

    public static final OfferDTOBuilder getOfferDTOBuilder(){
        return new OfferDTOBuilder();
    }

    public final OfferDTOBuilder setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final OfferDTOBuilder setStudent(final StudentDTO student) {
        this.student = student;
        return this;
    }

    public final OfferDTOBuilder setPrice(final int price) {
        this.price = price;
        return this;
    }

    public final OfferDTOBuilder setAdditionalInfo(final String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public final OfferDTO build(){
        return OfferDTO.create(id,student,price,additionalInfo);
    }
}
