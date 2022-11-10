package edu.uco.monitoria.data.dao.relational;

import edu.uco.monitoria.domain.PlaceDTO;

public interface PlaceDAO {
    void create(final PlaceDTO place);
    void update(final PlaceDTO place);
    void delete(PlaceDTO place);
}
