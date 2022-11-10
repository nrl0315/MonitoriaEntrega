package edu.uco.monitoria.domain.builder;

import edu.uco.monitoria.domain.StudentDTO;

import java.util.UUID;

public final class StudentDTOBuilder {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private String degree;

    private StudentDTOBuilder(){
        super();
    }

    public static final StudentDTOBuilder getStudentDTOBuilder(){
        return new StudentDTOBuilder();
    }

    public final StudentDTOBuilder setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final StudentDTOBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public final StudentDTOBuilder setSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public final StudentDTOBuilder setEmail(final String email) {
        this.email = email;
        return this;
    }

    public final StudentDTOBuilder setPhoneNumber(final int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public final StudentDTOBuilder setDegree(final String degree) {
        this.degree = degree;
        return this;
    }

    public final StudentDTO build(){
        return StudentDTO.create(id,name,surname,email,phoneNumber,degree);
    }
}
