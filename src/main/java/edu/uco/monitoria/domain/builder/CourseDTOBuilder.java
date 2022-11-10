package edu.uco.monitoria.domain.builder;

import java.util.UUID;
import edu.uco.monitoria.domain.CourseDTO;

public final class CourseDTOBuilder {
    private UUID id;
    private String name;
    private int semester;

    private CourseDTOBuilder(){
        super();
    }

    public static final CourseDTOBuilder getCourseDTOBuilder(){
        return new CourseDTOBuilder();
    }

    public final CourseDTOBuilder setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final CourseDTOBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public final CourseDTOBuilder setSemester(final int semester) {
        this.semester = semester;
        return this;
    }

    public final CourseDTO build(){
        return CourseDTO.create(id,name,semester);
    }

}
