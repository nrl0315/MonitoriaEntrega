package edu.uco.monitoria.service.command;

import edu.uco.monitoria.domain.PlaceDTO;

public interface DeletePlaceCommand {
    void delete(PlaceDTO place);
}
