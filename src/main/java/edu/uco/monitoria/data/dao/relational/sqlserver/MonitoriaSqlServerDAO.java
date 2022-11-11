package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.crosscuting.exception.data.DataCustomException;
import edu.uco.monitoria.crosscuting.helper.ObjectHelper;
import edu.uco.monitoria.crosscuting.helper.UUIDHelper;
import edu.uco.monitoria.crosscuting.messages.Messages;
import edu.uco.monitoria.data.dao.MonitoriaDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.MonitoriaDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        var parameters = new ArrayList<Object>();
        final var sqlBuilder = new StringBuilder();
        createSelectfrom(sqlBuilder);
        createWhere(sqlBuilder,budget,parameters);
        createOrderBy(sqlBuilder);
        return prepareAndExecuteQuery(sqlBuilder,parameters);
    }

    private final void createSelectfrom(final StringBuilder sqlBuilder){
        sqlBuilder.append("SELECT   mo.nombre AS monitorName, ");
        sqlBuilder.append("         pl.nombreBloque AS block, ");
        sqlBuilder.append("         pl.numeroAula AS classRoom, ");
        sqlBuilder.append("         bu.idPerson AS idPerson, ");
        sqlBuilder.append("         pe.idCard AS idCardPerson, ");
        sqlBuilder.append("         pe.firstName AS firstNamePerson, ");
        sqlBuilder.append("         pe.secondName AS secondNamePerson, ");
        sqlBuilder.append("         pe.firstSurname AS PersonFirstSurname, ");
        sqlBuilder.append("         pe.secondSurname AS PersonSecondSurname ");
        sqlBuilder.append("FROM     Budget bu INNER JOIN Year ye on bu.id = ye.id ");
        sqlBuilder.append("         INNER JOIN person pe on bu.id = pe.id ");
    }

    private final void createWhere(final StringBuilder sqlBuilder, final MonitoriaDTO monitoria, final List<Object> parameters){
        var setWhere = true;
        if(!ObjectHelper.isNull(monitoria.getId())){
            if(UUIDHelper.isDefaultUUID(monitoria.getId())){
                sqlBuilder.append("WHERE bu.id = ? ");
                setWhere = false;
                parameters.add(monitoria.getUUIDAsString());
            }
            if(UUIDHelper.isDefaultUUID(monitoria.getMonitor().getId())){
                sqlBuilder.append(setWhere ? "WHERE":"AND ").append("mo.idMonitor = ? ");
                setWhere = false;
                parameters.add(monitoria.getMonitor().getUUIDAsString());
            }
            if(UUIDHelper.isDefaultUUID(monitoria.getOffer().getId())){
                sqlBuilder.append(setWhere ? "WHERE":"AND ").append("mo.idOffer = ? ");
                parameters.add(monitoria.getOffer().getUUIDAsString());
            }
            if(UUIDHelper.isDefaultUUID(monitoria.getPlace().getId())){
                sqlBuilder.append(setWhere ? "WHERE":"AND ").append("mo.idPlace = ? ");
                parameters.add(monitoria.getPlace().getUUIDAsString());
            }
            if(UUIDHelper.isDefaultUUID(monitoria.getReview().getId())){
                sqlBuilder.append(setWhere ? "WHERE":"AND ").append("mo.idReview = ? ");
                parameters.add(monitoria.getReview().getUUIDAsString());
            }
            if(UUIDHelper.isDefaultUUID(monitoria.getSchedule().getId())){
                sqlBuilder.append(setWhere ? "WHERE":"AND ").append("mo.idSchedule = ? ");
                parameters.add(monitoria.getSchedule().getUUIDAsString());
            }
            if(UUIDHelper.isDefaultUUID(monitoria.getTopic().getId())){
                sqlBuilder.append(setWhere ? "WHERE":"AND ").append("mo.idTopic = ? ");
                parameters.add(monitoria.getTopic().getUUIDAsString());
            }
        }
    }

    private void createOrderBy(StringBuilder sqlBuilder) {
        sqlBuilder.append("ORDER BY mo.id ASC, ");
        sqlBuilder.append("to.id ASC ");
    }

    private final List<MonitoriaDTO> fillResults(final ResultSet resultSet){
        try{
            var results = new ArrayList<MonitoriaDTO>();
            while (resultSet.next()){
                results.add(fillMonitoriaDTO(resultSet));
            }
            return results;
        }catch (final DataCustomException exception){
            throw exception;
        }catch (final SQLException exception){
            throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_ERROR_FILLING_RESULTS, exception);
        }catch (final Exception exception){
            throw DataCustomException.createTechnicalException(Messages.BudgetSqlServerDAO.TECHNICAL_UNEXPECTED_ERROR_FILLING_RESULTS, exception);
        }
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
