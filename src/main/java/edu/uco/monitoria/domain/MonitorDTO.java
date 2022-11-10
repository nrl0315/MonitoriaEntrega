package edu.uco.monitoria.domain;

import edu.uco.monitoria.crosscuting.helper.UUIDHelper;

import static edu.uco.monitoria.crosscuting.helper.NumberHelper.DECIMAL_ZERO;
import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.monitoria.crosscuting.helper.NumberHelper.ZERO;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getUUIDFromString;

import java.util.UUID;

public final class MonitorDTO {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private String degree;
    private double note;

    public MonitorDTO(){
        setId(getDefaultUUID(id));
        setName(EMPTY);
        setSurname(EMPTY);
        setEmail(EMPTY);
        setPhoneNumber(ZERO);
        setDegree(EMPTY);
        setNote(DECIMAL_ZERO);
    }

    public MonitorDTO(final UUID id, final String name, final String surname, final String email, final int phoneNumber, final String degree,
    final double note){
        setId(id);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setDegree(degree);
        setNote(note);
    }

    public static final MonitorDTO create(final UUID id, final String name, final String surname, final String email, final int phoneNumber, final String degree,
                                          final double note){
        return new MonitorDTO(id,name,surname,email,phoneNumber,degree,note);
    }

    public static final MonitorDTO create(final String id, final String name, final String surnane, final String email, final int phoneNumber, final String degree,
                                    final double note){
        return new MonitorDTO(getUUIDFromString(id),name,surnane,email,phoneNumber,degree,note);
    }


    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
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

    public long getPhoneNumber() {
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

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
    public final String getUUIDAsString(){
        return UUIDHelper.getUUIDAsString(getId());
    }
}
