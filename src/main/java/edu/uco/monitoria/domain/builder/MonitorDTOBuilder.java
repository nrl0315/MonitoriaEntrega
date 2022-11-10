package edu.uco.monitoria.domain.builder;

import java.util.UUID;
import edu.uco.monitoria.domain.MonitorDTO;

public final class MonitorDTOBuilder {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private String degree;
    private double note;

    private MonitorDTOBuilder(){
        super();
    }

    public static final MonitorDTOBuilder getMonitorDTOBuilder(){
        return new MonitorDTOBuilder();
    }

    public final MonitorDTOBuilder setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final MonitorDTOBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public final MonitorDTOBuilder setSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public final MonitorDTOBuilder setEmail(final String email) {
        this.email = email;
        return this;
    }

    public final MonitorDTOBuilder setPhoneNumber(final int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public final MonitorDTOBuilder setDegree(final String degree) {
        this.degree = degree;
        return this;
    }

    public final MonitorDTOBuilder setNote(final double note) {
        this.note = note;
        return this;
    }

    public final MonitorDTO build() {
        return MonitorDTO.create(id,name,surname,email,phoneNumber,degree,note);
    }

}
