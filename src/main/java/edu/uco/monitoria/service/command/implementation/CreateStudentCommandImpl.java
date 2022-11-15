package edu.uco.monitoria.service.command.implementation;

import edu.uco.monitoria.crosscuting.exception.data.MonitoriaCustomException;
import edu.uco.monitoria.crosscuting.exception.usecase.UseCaseCustomException;
import edu.uco.monitoria.data.daofactory.DAOFactory;
import edu.uco.monitoria.data.enumeration.DAOFactoryType;
import edu.uco.monitoria.domain.StudentDTO;
import edu.uco.monitoria.service.command.CreateStudentCommand;
import edu.uco.monitoria.service.usecase.student.CreateStudentUseCase;
import edu.uco.monitoria.service.usecase.student.implementation.CreateStudentUseCaseImpl;

public class CreateStudentCommandImpl implements CreateStudentCommand {
    private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER);
    private final CreateStudentUseCase useCase = new CreateStudentUseCaseImpl(factory);

    @Override
    public void execute(StudentDTO student) {
        try{
            factory.initTransaction();
            useCase.execute(student);
            factory.confirmTransaction();
        }catch(UseCaseCustomException exception){
            factory.cancelTransaction();
            throw exception;
        }catch(final MonitoriaCustomException exception){
            factory.cancelTransaction();
            throw UseCaseCustomException.wrapException(null,exception);
        }catch(final Exception exception){
            factory.cancelTransaction();
            throw UseCaseCustomException.createBusinessException(null,exception);
        } finally {
            factory.closeConnection();
        }
    }
}
