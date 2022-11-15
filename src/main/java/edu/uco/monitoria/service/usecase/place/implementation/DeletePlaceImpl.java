package edu.uco.monitoria.service.usecase.place.implementation;

import edu.uco.monitoria.crosscuting.exception.usecase.UseCaseCustomException;
import edu.uco.monitoria.crosscuting.messages.Messages;
import edu.uco.monitoria.data.daofactory.DAOFactory;
import edu.uco.monitoria.domain.PlaceDTO;
import edu.uco.monitoria.service.usecase.place.DeletePlace;
import edu.uco.monitoria.service.usecase.place.FindPlaceById;

import java.util.List;

public class DeletePlaceImpl implements DeletePlace {
    private final DAOFactory factory;
    private final FindPlaceById findPlace;

    public DeletePlaceImpl(DAOFactory factory){
        this.factory = factory;
        findPlace = new FindPlaceByIdImpl(factory);
    }
    @Override
    public void delete(PlaceDTO place) {
        place.setId(place.getId());
        factory.getPlaceDAO().delete(place);
    }

    private final void validateIfPlaceExist(PlaceDTO place){
        final List<PlaceDTO> results = findPlace.execute(place);
        if(!results.isEmpty()){
            throw UseCaseCustomException.createUserException(Messages.CreateStudentUseCaseImpl.BUSSINES_PLACE_ALREADY_EXISTS);
        }
    }
}
