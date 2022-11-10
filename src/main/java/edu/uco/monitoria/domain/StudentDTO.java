package edu.uco.monitoria.domain;

import edu.uco.monitoria.crosscuting.helper.UUIDHelper;

import java.util.UUID;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;
import static edu.uco.monitoria.crosscuting.helper.NumberHelper.ZERO;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getUUIDFromString;

public final class StudentDTO {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private String degree;

    public StudentDTO(){
        setId(getDefaultUUID(id));
        setName(EMPTY);
        setSurname(EMPTY);
        setEmail(EMPTY);
        setPhoneNumber(ZERO);
        setDegree(EMPTY);
    }

    public StudentDTO(UUID id, String name, String surname, String email, int phoneNumber, String degree) {
        setId(id);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setDegree(degree);
    }

    public static final StudentDTO create(final UUID id, final String name, final String surname, final String email, final int phoneNumber, final String degree){
        return new StudentDTO(id,name,surname,email,phoneNumber,degree);
    }

    public static final StudentDTO create(final String id, final String name, final String surname, final String email, final int phoneNumber, final String degree){
        return new StudentDTO(getUUIDFromString(id),name, surname,email,phoneNumber,degree);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public final String getUUIDAsString(){
        return UUIDHelper.getUUIDAsString(getId());
    }
}
