package edu.uco.monitoria.service.usecase.place.implementation;

import edu.uco.monitoria.crosscuting.exception.usecase.UseCaseCustomException;
import edu.uco.monitoria.crosscuting.helper.UUIDHelper;
import edu.uco.monitoria.crosscuting.messages.Messages;
import edu.uco.monitoria.data.daofactory.DAOFactory;
import edu.uco.monitoria.domain.PlaceDTO;
import edu.uco.monitoria.domain.StudentDTO;
import edu.uco.monitoria.service.usecase.place.CreatePlaceUseCase;
import edu.uco.monitoria.service.usecase.place.FindPlaceById;
import edu.uco.monitoria.service.usecase.student.implementation.FindStudentByIdImpl;

import java.util.List;

public class CreatePlaceUseCaseImpl implements CreatePlaceUseCase {

    private final DAOFactory factory;
    private final FindPlaceById findPlace;

    public CreatePlaceUseCaseImpl(DAOFactory factory){
        this.factory = factory;
         findPlace = new FindPlaceByIdImpl(factory);
    }

    @Override
    public void execute(PlaceDTO place) {
        place.setId(UUIDHelper.getNewUUID());
        place.setBlock(place.getBlock());
        place.setClassRoom(place.getClassRoom());
        factory.getPlaceDAO().create(place);
    }

    private final void validateIfPlaceExist(PlaceDTO place){
        final List<PlaceDTO> results = findPlace.execute(place);
        if(!results.isEmpty()){
            throw UseCaseCustomException.createUserException(Messages.CreateStudentUseCaseImpl.BUSSINES_PLACE_ALREADY_EXISTS);
        }
    }
}
