package edu.uco.monitoria.domain.builder;

import edu.uco.monitoria.domain.CourseDTO;
import edu.uco.monitoria.domain.TopicDTO;

import java.util.UUID;

public final class TopicDTOBuilder {
    private CourseDTO course;
    private UUID id;
    private String name;
    private String description;

    private TopicDTOBuilder(){
        super();
    }

    public static final TopicDTOBuilder getTopicDTOBuilder(){
        return new TopicDTOBuilder();
    }

    public final TopicDTOBuilder setCourse(final CourseDTO course) {
        this.course = course;
        return this;
    }

    public final TopicDTOBuilder setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final TopicDTOBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public final TopicDTOBuilder setDescription(final String description) {
        this.description = description;
        return this;
    }

    public final TopicDTO build(){
        return TopicDTO.create(id,name,description,course);
    }

}
