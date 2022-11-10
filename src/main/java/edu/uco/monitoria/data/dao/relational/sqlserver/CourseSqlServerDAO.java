package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.data.dao.CourseDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.CourseDTO;

import java.sql.Connection;
import java.util.List;

public class CourseSqlServerDAO extends DAORelational implements CourseDAO {
    protected CourseSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(CourseDTO course) {

    }

    @Override
    public void update(CourseDTO course) {

    }

    @Override
    public List<CourseDTO> find(CourseDTO course) {
        return null;
    }

    @Override
    public void delete(CourseDTO course) {

    }
}
