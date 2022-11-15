package edu.uco.monitoria.service.usecase.place;

import edu.uco.monitoria.domain.PlaceDTO;
import edu.uco.monitoria.domain.StudentDTO;

import java.util.List;
import java.util.UUID;

public interface FindPlaceById {
    List<PlaceDTO> execute(PlaceDTO place);
}
