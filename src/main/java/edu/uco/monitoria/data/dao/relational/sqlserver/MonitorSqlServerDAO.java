package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.crosscuting.exception.data.DataCustomException;
import edu.uco.monitoria.crosscuting.messages.Messages;
import edu.uco.monitoria.data.dao.MonitorDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.MonitorDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MonitorSqlServerDAO extends DAORelational implements MonitorDAO {
    protected MonitorSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(MonitorDTO monitor) {
        final var sql = "INSERT INTO monitor (id,nombre,apellido,correoElectronico,numeroTelefonico,nombreCarrera,notaAsignatura) " +
                "VALUES (?,?,?,?,?,?,?)";
        try(final var preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1,monitor.getUUIDAsString());
            preparedStatement.setString(2,monitor.getName());
            preparedStatement.setString(3,monitor.getSurname());
            preparedStatement.setString(4, monitor.getEmail());
            preparedStatement.setString(5, String.valueOf(monitor.getPhoneNumber()));
            preparedStatement.setString(6,monitor.getDegree());
            preparedStatement.setString(7, String.valueOf(monitor.getNote()));
            preparedStatement.executeUpdate();
        } catch(SQLException exception){
            String message = Messages.MonitoriaSqlServerDAO.TECHNICAL_ERROR_CREATING_MONITOR.concat(monitor.getUUIDAsString());
            throw DataCustomException.createTechnicalException(message,exception);
        } catch(Exception exception){
            throw DataCustomException.createTechnicalException(Messages.MonitoriaSqlServerDAO.TECHNICAL_UNEXPECTED_ERROR_CREATING_MONITOR,exception);
        }

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
