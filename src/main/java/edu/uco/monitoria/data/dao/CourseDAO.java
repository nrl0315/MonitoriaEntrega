package edu.uco.monitoria.data.dao;

import edu.uco.monitoria.domain.CourseDTO;

import java.util.List;

public interface CourseDAO {
    void create(final CourseDTO course);
    void update(final CourseDTO course);
    List<CourseDTO> find(final CourseDTO course);
    void delete(CourseDTO course);
}
