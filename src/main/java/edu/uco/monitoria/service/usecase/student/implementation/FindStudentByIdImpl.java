package edu.uco.monitoria.service.usecase.student.implementation;

import edu.uco.monitoria.data.daofactory.DAOFactory;
import edu.uco.monitoria.domain.StudentDTO;
import edu.uco.monitoria.service.usecase.student.FindStudentById;

import java.util.List;
import java.util.UUID;

public class FindStudentByIdImpl implements FindStudentById {
    private final DAOFactory factory;
    public FindStudentByIdImpl(DAOFactory factory){
        this.factory = factory;
    }

    @Override
    public List<StudentDTO> execute(StudentDTO student) {
        return factory.getStudentDAO().find(student);
    }

}
