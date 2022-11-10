package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.data.dao.ScheduleDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.ScheduleDTO;

import java.sql.Connection;
import java.util.List;

public class ScheduleSqlServerDAO extends DAORelational implements ScheduleDAO {
    protected ScheduleSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(ScheduleDTO schedule) {

    }

    @Override
    public void update(ScheduleDTO schedule) {

    }

    @Override
    public List<ScheduleDTO> find(ScheduleDTO schedule) {
        return null;
    }

    @Override
    public void delete(ScheduleDTO schedule) {

    }
}
