package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.crosscuting.exception.data.DataCustomException;
import edu.uco.monitoria.crosscuting.messages.Messages;
import edu.uco.monitoria.data.dao.PlaceDAO;
import edu.uco.monitoria.data.dao.relational.DAORelational;
import edu.uco.monitoria.domain.PlaceDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlaceSqlServerDAO extends DAORelational implements PlaceDAO {
    protected PlaceSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public List<PlaceDTO> find(PlaceDTO place) {
        return null;
    }

    @Override
    public void create(PlaceDTO place) {
        final var sql = "INSERT INTO lugar (id, nombreBloque, numeroAula) VALUES (?,?,?)";
        try(final var preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1,place.getUUIDAsString());
            preparedStatement.setString(2,place.getBlock());
            preparedStatement.setString(3, place.getClassRoom());
            preparedStatement.executeUpdate();
        } catch(SQLException exception){
            String message = Messages.MonitoriaSqlServerDAO.TECHNICAL_ERROR_TRYING_TO_CREATE_PLACE.concat(place.getUUIDAsString());
            throw DataCustomException.createTechnicalException(message,exception);
        } catch(Exception exception){
            throw DataCustomException.createTechnicalException(Messages.MonitoriaSqlServerDAO.TECHNICAL_UNEXPECTED_ERROR_WHEN_TRYING_TO_CREATE_THE_PLACE,exception);
        }
    }

    @Override
    public void update(PlaceDTO place) {

    }

    @Override
    public void delete(PlaceDTO place) {

    }
}
