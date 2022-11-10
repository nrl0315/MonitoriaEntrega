package edu.uco.monitoria.domain;

import java.util.UUID;
import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.monitoria.crosscuting.helper.NumberHelper.ZERO;

public final class CourseDTO {
    private UUID id;
    private String name;
    private int semester;

    public CourseDTO(){
        setId(getDefaultUUID(id));
        setName(EMPTY);
        setSemester(ZERO);
    }

    public CourseDTO(UUID id, String name, int semester) {
        setId(getDefaultUUID(id));
        setName(name);
        setSemester(semester);
    }

    public static final CourseDTO create(final UUID id, final String name, final int semester){
        return new CourseDTO(id,name,semester);
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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
