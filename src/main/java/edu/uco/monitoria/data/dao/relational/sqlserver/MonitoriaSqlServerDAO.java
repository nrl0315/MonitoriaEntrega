package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.data.dao.MonitoriaDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.MonitoriaDTO;

import java.sql.Connection;
import java.util.List;

public class MonitoriaSqlServerDAO extends DAORelational implements MonitoriaDAO {
    protected MonitoriaSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(MonitoriaDTO monitoria) {
        final var sql = "INSERT INTO monitoria (id,monitor,place,schedule,topic,review,offer) VALUES (?,?,?,?,?,?,?)";
        
    }

    @Override
    public void update(MonitoriaDTO monitoria) {

    }

    @Override
    public List<MonitoriaDTO> find(MonitoriaDTO monitoria) {
        return null;
    }

    @Override
    public void delete(MonitoriaDTO monitoria) {

    }
}
