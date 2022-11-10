package edu.uco.monitoria.data.dao.relational;

import edu.uco.monitoria.domain.OfferDTO;

public interface OfferDAO {
    void create(final OfferDTO offer);
    void update(final OfferDTO offer);
    void delete(OfferDTO offer);
}
