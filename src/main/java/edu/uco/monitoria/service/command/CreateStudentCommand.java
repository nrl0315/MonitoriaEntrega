package edu.uco.monitoria.service.command;

import edu.uco.monitoria.domain.StudentDTO;

public interface CreateStudentCommand {
    void execute(StudentDTO student);
}
