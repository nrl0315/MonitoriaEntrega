package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.data.dao.MonitorDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.MonitorDTO;

import java.sql.Connection;
import java.util.List;

public class MonitorSqlServerDAO extends DAORelational implements MonitorDAO {
    protected MonitorSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(MonitorDTO monitor) {

    }

    @Override
    public void update(MonitorDTO monitor) {

    }

    @Override
    public List<MonitorDTO> find(MonitorDTO monitor) {
        return null;
    }

    @Override
    public void delete(MonitorDTO monitor) {

    }
}
