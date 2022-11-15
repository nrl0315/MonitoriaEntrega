package edu.uco.monitoria.service.usecase.place;

import edu.uco.monitoria.domain.PlaceDTO;

public interface CreatePlaceUseCase {
    void execute(PlaceDTO place);
}
