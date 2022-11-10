package edu.uco.monitoria.domain;

import java.util.UUID;
import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.monitoria.domain.builder.CourseDTOBuilder.getCourseDTOBuilder;

public final class TopicDTO {
    private CourseDTO course;
    private UUID id;
    private String name;
    private String description;

    public TopicDTO(){
        setId(getDefaultUUID(id));
        setName(EMPTY);
        setDescription(EMPTY);
        setCourse(getCourseDTOBuilder().build());
    }

    public TopicDTO(final UUID id, final String name, final String description, final CourseDTO course) {
        setId(getDefaultUUID(id));
        setName(name);
        setDescription(description);
        setCourse(course);
    }

    public final static TopicDTO create(final UUID id, final String name, final String description, final CourseDTO course){
        return new TopicDTO(id,name,description,course);
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
