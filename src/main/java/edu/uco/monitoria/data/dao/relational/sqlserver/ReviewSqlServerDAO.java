package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.data.dao.ReviewDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.ReviewDTO;

import java.sql.Connection;
import java.util.List;

public class ReviewSqlServerDAO extends DAORelational implements ReviewDAO {
    protected ReviewSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(ReviewDTO review) {

    }

    @Override
    public List<ReviewDTO> find(ReviewDTO review) {
        return null;
    }

    @Override
    public void update(ReviewDTO review) {

    }
}
