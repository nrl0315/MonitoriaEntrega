package edu.uco.monitoria.service.usecase.place.implementation;

import edu.uco.monitoria.data.daofactory.DAOFactory;
import edu.uco.monitoria.domain.PlaceDTO;
import edu.uco.monitoria.service.usecase.place.FindPlaceById;

import java.util.List;
import java.util.UUID;

public class FindPlaceByIdImpl implements FindPlaceById {
    private final DAOFactory factory;
    public FindPlaceByIdImpl(DAOFactory factory){
        this.factory = factory;
    }
    @Override
    public PlaceDTO execute(UUID id) {
        PlaceDTO result = new PlaceDTO();
        final PlaceDTO place = PlaceDTO.create(id);
        final List<PlaceDTO> results = factory.getPlaceDAO().find(place);
        if(!results.isEmpty()){
            result = results.get(0);
        }
        return null;
    }
}
