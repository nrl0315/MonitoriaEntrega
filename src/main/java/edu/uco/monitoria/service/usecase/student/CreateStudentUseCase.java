package edu.uco.monitoria.service.usecase.student;

import edu.uco.monitoria.domain.StudentDTO;

public interface CreateStudentUseCase {
    void execute(StudentDTO student);
}
