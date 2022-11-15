package edu.uco.monitoria.service.command.implementation;

import edu.uco.monitoria.crosscuting.exception.data.MonitoriaCustomException;
import edu.uco.monitoria.crosscuting.exception.usecase.UseCaseCustomException;
import edu.uco.monitoria.data.daofactory.DAOFactory;
import edu.uco.monitoria.data.enumeration.DAOFactoryType;
import edu.uco.monitoria.domain.PlaceDTO;
import edu.uco.monitoria.service.command.CreatePlaceCommand;
import edu.uco.monitoria.service.usecase.place.CreatePlaceUseCase;
import edu.uco.monitoria.service.usecase.place.implementation.CreatePlaceUseCaseImpl;

public class CreatePlaceCommandImpl implements CreatePlaceCommand {
    private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER);
    private final CreatePlaceUseCase useCase = new CreatePlaceUseCaseImpl(factory);
    @Override
    public void execute(PlaceDTO place) {
        try{
            factory.initTransaction();
            useCase.execute(place);
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
