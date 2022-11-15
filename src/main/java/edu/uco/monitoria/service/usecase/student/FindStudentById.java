package edu.uco.monitoria.service.usecase.student;

import edu.uco.monitoria.domain.StudentDTO;

import java.util.List;
import java.util.UUID;

public interface FindStudentById {
    List<StudentDTO> execute(StudentDTO student);
}
