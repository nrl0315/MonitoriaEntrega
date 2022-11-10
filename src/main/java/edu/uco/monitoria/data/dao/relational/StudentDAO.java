package edu.uco.monitoria.data.dao.relational;

import edu.uco.monitoria.domain.StudentDTO;

import java.util.List;

public interface StudentDAO {
    void create(final StudentDTO student);
    void update(final StudentDTO student);
    List<StudentDTO> find(final StudentDTO student);
    void delete(StudentDTO student);
}
