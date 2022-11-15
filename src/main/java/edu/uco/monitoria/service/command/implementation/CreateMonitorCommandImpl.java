package edu.uco.monitoria.service.command.implementation;

import edu.uco.monitoria.crosscuting.exception.data.MonitoriaCustomException;
import edu.uco.monitoria.crosscuting.exception.usecase.UseCaseCustomException;
import edu.uco.monitoria.data.daofactory.DAOFactory;
import edu.uco.monitoria.data.enumeration.DAOFactoryType;
import edu.uco.monitoria.domain.MonitorDTO;
import edu.uco.monitoria.service.command.CreateMonitorCommand;
import edu.uco.monitoria.service.usecase.monitor.CreateMonitorUseCase;
import edu.uco.monitoria.service.usecase.monitor.implementation.CreateMonitorUseCaseImpl;

public class CreateMonitorCommandImpl implements CreateMonitorCommand {

    private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER);
    private final CreateMonitorUseCase useCase = new CreateMonitorUseCaseImpl(factory);

    @Override
    public void execute(MonitorDTO monitor) {
        try{
            factory.initTransaction();
            useCase.execute(monitor);
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
