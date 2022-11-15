package edu.uco.monitoria.service.usecase.student.implementation;

import edu.uco.monitoria.crosscuting.exception.usecase.UseCaseCustomException;
import edu.uco.monitoria.crosscuting.helper.UUIDHelper;
import edu.uco.monitoria.crosscuting.messages.Messages;
import edu.uco.monitoria.data.daofactory.DAOFactory;
import edu.uco.monitoria.domain.StudentDTO;
import edu.uco.monitoria.service.usecase.student.CreateStudentUseCase;

import java.util.List;
import java.util.UUID;

public final class CreateStudentUseCaseImpl implements CreateStudentUseCase {
    private final DAOFactory factory;
    private final FindStudentByIdImpl findStudentById;
    public CreateStudentUseCaseImpl(DAOFactory factory){
        this.factory = factory;
        findStudentById = new FindStudentByIdImpl(factory);
    }

    @Override
    public final void execute(StudentDTO student) {
        student.setId(UUIDHelper.getNewUUID());
        student.setName(student.getName());
        student.setSurname(student.getSurname());
        student.setDegree(student.getDegree());
        student.setEmail(student.getEmail());
        student.setPhoneNumber(student.getPhoneNumber());
        factory.getStudentDAO().create(student);
    }

    private final void validateIfStudentExist(StudentDTO student){
        final List<StudentDTO> results = findStudentById.execute(student);
        if(!results.isEmpty()){
            throw UseCaseCustomException.createUserException(Messages.CreateStudentUseCaseImpl.BUSSINES_STUDENT_ALREADY_EXISTS);
        }
    }
}


