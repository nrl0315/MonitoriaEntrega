package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.data.dao.OfferDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.OfferDTO;

import java.sql.Connection;

public class OfferSqlServerDAO extends DAORelational implements OfferDAO {

    protected OfferSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(OfferDTO offer) {

    }

    @Override
    public void update(OfferDTO offer) {

    }

    @Override
    public void delete(OfferDTO offer) {

    }
}
