package edu.uco.monitoria.service.usecase.student;

import edu.uco.monitoria.domain.StudentDTO;

import java.util.UUID;

public interface FindStudentById {
    StudentDTO execute(UUID id);
}
