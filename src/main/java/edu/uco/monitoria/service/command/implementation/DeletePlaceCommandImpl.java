package edu.uco.monitoria.service.command.implementation;

import edu.uco.monitoria.crosscuting.exception.data.MonitoriaCustomException;
import edu.uco.monitoria.crosscuting.exception.usecase.UseCaseCustomException;
import edu.uco.monitoria.data.daofactory.DAOFactory;
import edu.uco.monitoria.data.enumeration.DAOFactoryType;
import edu.uco.monitoria.domain.PlaceDTO;
import edu.uco.monitoria.service.command.DeletePlaceCommand;
import edu.uco.monitoria.service.usecase.place.DeletePlace;
import edu.uco.monitoria.service.usecase.place.implementation.DeletePlaceImpl;

public class DeletePlaceCommandImpl implements DeletePlaceCommand {
    private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactoryType.SQLSERVER);
    private final DeletePlace useCase = new DeletePlaceImpl(factory);

    @Override
    public void delete(PlaceDTO place) {
        try {
            factory.initTransaction();
            useCase.delete(place);
            factory.confirmTransaction();
        } catch (final UseCaseCustomException exception) {
            factory.cancelTransaction();
        } catch (final MonitoriaCustomException exception) {
            factory.cancelTransaction();
            throw UseCaseCustomException.wrapException(null, exception);
        } catch (final Exception exception) {
            throw UseCaseCustomException.createBusinessException(null, exception);
        } finally {
            factory.closeConnection();
        }
    }
}
