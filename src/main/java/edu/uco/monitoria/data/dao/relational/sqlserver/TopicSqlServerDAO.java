package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.data.dao.TopicDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.TopicDTO;

import java.sql.Connection;
import java.util.List;

public class TopicSqlServerDAO extends DAORelational implements TopicDAO {
    protected TopicSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(TopicDTO topic) {

    }

    @Override
    public void update(TopicDTO topic) {

    }

    @Override
    public List<TopicDTO> find(TopicDTO topic) {
        return null;
    }

    @Override
    public void delete(TopicDTO topic) {

    }
}
