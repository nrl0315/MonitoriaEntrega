package edu.uco.monitoria.domain;

import java.util.UUID;
import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getDefaultUUID;

public class TopicDTO {
    private CourseDTO course;
    private UUID id;
    private String name;
    private String description;

    public TopicDTO(){
        setId(getDefaultUUID(id));
        setName(EMPTY);
        setDescription(EMPTY);

    }

    public TopicDTO(UUID id, String name, String description) {
        setId(getDefaultUUID(id));
        setName(name);
        setDescription(description);
    }

    public final static TopicDTO create(final UUID id, final String name, final String description){
        return new TopicDTO(id,name,description);
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

    public void setId(UUID id) {
        this.id = id;
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
