package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.data.dao.PlaceDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.PlaceDTO;

import java.sql.Connection;
import java.util.List;

public class PlaceSqlServerDAO extends DAORelational implements PlaceDAO {
    protected PlaceSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public List<PlaceDTO> find(PlaceDTO place) {
        return null;
    }

    @Override
    public void create(PlaceDTO place) {

    }

    @Override
    public void update(PlaceDTO place) {

    }

    @Override
    public void delete(PlaceDTO place) {

    }
}
