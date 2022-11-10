package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.data.dao.StudentDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.StudentDTO;

import java.sql.Connection;
import java.util.List;

public class StudentSqlServerDAO extends DAORelational implements StudentDAO {
    protected StudentSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(StudentDTO student) {

    }

    @Override
    public void update(StudentDTO student) {

    }

    @Override
    public List<StudentDTO> find(StudentDTO student) {
        return null;
    }

    @Override
    public void delete(StudentDTO student) {

    }
}
