package edu.uco.monitoria.data.daofactory;

import edu.uco.monitoria.crosscuting.exception.crosscuting.CrosscutingCustomException;
import edu.uco.monitoria.crosscuting.exception.data.DataCustomException;
import edu.uco.monitoria.crosscuting.helper.SqlConnectionHelper;
import edu.uco.monitoria.crosscuting.messages.Messages;
import edu.uco.monitoria.data.dao.*;

import java.sql.Connection;

public final class SqlServerDAOFactory extends DAOFactory{
    private Connection connection;

    SqlServerDAOFactory(){
        openConnection();
    }

    @Override
    protected void openConnection() {

    }

    @Override
    public void initTransaction() {
        try{
            SqlConnectionHelper.innitTransaction(connection);
        } catch (CrosscutingCustomException exception){
            throw DataCustomException.createTechnicalException(Messages.SQLDAOFactory.TECHNICAL_PROBLEM_INIT_TRANSACTION,new Exception());
        }
    }

    @Override
    public void confirmTransaction() {

    }

    @Override
    public void cancelTransaction() {

    }

    @Override
    public void closeConnection() {

    }

    @Override
    public CourseDAO getCourseDAO() {
        return null;
    }

    @Override
    public MonitorDAO getMonitorDAO() {
        return null;
    }

    @Override
    public MonitoriaDAO getMonitoriaDAO() {
        return null;
    }

    @Override
    public OfferDAO getOfferDAO() {
        return null;
    }

    @Override
    public PlaceDAO getPlaceDAO() {
        return null;
    }

    @Override
    public ReviewDAO getReviewDAO() {
        return null;
    }

    @Override
    public ScheduleDAO getScheduleDAO() {
        return null;
    }

    @Override
    public StudentDAO getStudentDAO() {
        return null;
    }

    @Override
    public TopicDAO getTopicDAO() {
        return null;
    }
}
