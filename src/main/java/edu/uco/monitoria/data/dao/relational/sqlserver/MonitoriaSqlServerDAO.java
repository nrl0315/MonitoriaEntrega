package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.crosscuting.exception.data.DataCustomException;
import edu.uco.monitoria.crosscuting.messages.Messages;
import edu.uco.monitoria.data.dao.MonitoriaDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.MonitoriaDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MonitoriaSqlServerDAO extends DAORelational implements MonitoriaDAO {
    protected MonitoriaSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(MonitoriaDTO monitoria) {
        final var sql = "INSERT INTO monitoria (id,monitor,place,schedule,topic,review,offer) VALUES (?,?,?,?,?,?,?)";

        try(final var preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1,monitoria.getUUIDAsString());
            preparedStatement.setString(2,monitoria.getMonitor().getUUIDAsString());
            preparedStatement.setString(3,monitoria.getPlace().getUUIDAsString());
            preparedStatement.setString(4,monitoria.getSchedule().getUUIDAsString());
            preparedStatement.setString(5,monitoria.getTopic().getUUIDAsString());
            preparedStatement.setString(6,monitoria.getReview().getUUIDAsString());
            preparedStatement.setString(7,monitoria.getOffer().getUUIDAsString());
            preparedStatement.executeUpdate();
        }catch(final SQLException exception){
            String message = Messages.MonitoriaSqlServerDAO.TECHNICAL_ERROR_WHEN_TRYING_TO_CREATE_MONITORIA.concat(monitoria.getUUIDAsString());
            throw DataCustomException.createTechnicalException(message,exception);
        }catch(final Exception exception){
            throw DataCustomException.createTechnicalException(Messages.MonitoriaSqlServerDAO.TECHNICAL_UNEXPECTED_ERROR_WHEN_TRYING_TO_CREATE_MONITORIA,exception);
        }
    }

    @Override
    public void update(MonitoriaDTO monitoria) {
        final var sql = "UPDATE monitoria SET monitor = ? , place = ?,schedule = ?,topic = ?,review = ?,offer = ? WHERE id = ?";
        try(final var preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1,monitoria.getMonitor().getUUIDAsString());
            preparedStatement.setString(2,monitoria.getPlace().getUUIDAsString());
            preparedStatement.setString(3,monitoria.getSchedule().getUUIDAsString());
            preparedStatement.setString(4,monitoria.getTopic().getUUIDAsString());
            preparedStatement.setString(5,monitoria.getReview().getUUIDAsString());
            preparedStatement.setString(6,monitoria.getOffer().getUUIDAsString());
            preparedStatement.setString(7,monitoria.getUUIDAsString());
            preparedStatement.executeUpdate();
        }catch(final SQLException exception){
            String message = Messages.MonitoriaSqlServerDAO.TECHNICAL_ERROR_WHEN_TRYING_TO_UPDATE_THE_SELECTED_MONITORIA.concat(monitoria.getUUIDAsString());
            throw DataCustomException.createTechnicalException(message,exception);
        }catch(final Exception exception){
            throw DataCustomException.createTechnicalException(Messages.MonitoriaSqlServerDAO.TECHNICAL_UNEXPECTED_ERROR_WHEN_TRYING_TO_UPDATE_THE_SELECTED_MONITORIA,exception);
        }
    }

    @Override
    public List<MonitoriaDTO> find(MonitoriaDTO monitoria) {
        return null;
    }

    @Override
    public void delete(MonitoriaDTO monitoria) {
        final var sql = "DELET FROM monitoria WHERE id = ?";
        try(final var preparedStatement = getConnection().prepareStatement(sql)){

        }catch(final SQLException exception){
            String message = Messages.MonitoriaSqlServerDAO.TECHNICAL_ERROR_WHEN_TRYING_TO_DELETE_MONITORIA.concat(monitoria.getUUIDAsString());
            throw DataCustomException.createTechnicalException(message,exception);
        }catch(final Exception exception){
            throw DataCustomException.createTechnicalException(Messages.MonitoriaSqlServerDAO.TECHNICAL_UNEXPECTED_ERROR_WHEN_TRYING_TO_DELETE_MONITORIA,exception);
        }
    }
}
