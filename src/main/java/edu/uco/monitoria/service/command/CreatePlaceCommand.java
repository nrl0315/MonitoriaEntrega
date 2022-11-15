package edu.uco.monitoria.service.command;

import edu.uco.monitoria.domain.PlaceDTO;

public interface CreatePlaceCommand {
    void execute(PlaceDTO place);
}
