package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.crosscuting.exception.data.DataCustomException;
import edu.uco.monitoria.crosscuting.messages.Messages;
import edu.uco.monitoria.data.dao.StudentDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.StudentDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentSqlServerDAO extends DAORelational implements StudentDAO {
    protected StudentSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(StudentDTO student) {
        final var sql = "INSERT INTO estudiante (id,nombre,apellido,correoElctronico,numeroTelefonico,nombreCarrera) VALUES (?,?,?,?,?,?)";
        try(final var preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1,student.getUUIDAsString());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, String.valueOf(student.getPhoneNumber()));
            preparedStatement.setString(6,student.getDegree());
            preparedStatement.executeUpdate();
        } catch(SQLException exception){
            String message = Messages.MonitoriaSqlServerDAO.TECHNICAL_ERROR_TRYING_TO_CREATE_STUDENT.concat(student.getUUIDAsString());
            throw DataCustomException.createTechnicalException(message,exception);
        } catch (Exception exception){
            throw DataCustomException.createTechnicalException(Messages.MonitoriaSqlServerDAO.TECHNICAL_UNEXPECTED_ERROR_WHEN_TRYING_TO_CREATE_STUDENT,exception);
        }
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
