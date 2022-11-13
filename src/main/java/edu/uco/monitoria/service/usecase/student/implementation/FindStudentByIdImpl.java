package edu.uco.monitoria.service.usecase.student.implementation;


import edu.uco.monitoria.data.daofactory.DAOFactory;
import edu.uco.monitoria.domain.StudentDTO;
import edu.uco.monitoria.service.usecase.student.FindStudentById;

import java.util.List;
import java.util.UUID;

public class FindStudentByIdImpl  implements FindStudentById {

    private final DAOFactory factory;
    public FindStudentByIdImpl(DAOFactory factory){
        this.factory = factory;
    }

    @Override
    public StudentDTO execute(UUID id) {
        StudentDTO result = new StudentDTO();
        final StudentDTO student  = StudentDTO.create(id);
        final List<StudentDTO> results = factory.getStudentDAO().find(student);

        if(!results.isEmpty()){
            result = results.get(0);
        }
        return null;
    }
}
