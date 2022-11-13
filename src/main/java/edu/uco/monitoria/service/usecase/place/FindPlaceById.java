package edu.uco.monitoria.service.usecase.place;

import edu.uco.monitoria.domain.PlaceDTO;

import java.util.UUID;

public interface FindPlaceById {
    PlaceDTO execute(UUID id);
}
