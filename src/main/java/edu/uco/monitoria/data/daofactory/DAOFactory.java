package edu.uco.monitoria.data.daofactory;
import edu.uco.monitoria.data.dao.relational.*;
import edu.uco.monitoria.data.enumeration.DAOFactoryType;
import edu.uco.monitoria.crosscuting.messages.Messages;


public abstract class DAOFactory {
    public static final DAOFactory getDAOFactory(final DAOFactoryType factory){

        DAOFactory daoFactory;

        switch (factory){
            case SQLSERVER :
                daoFactory = new SqlServerDAOFactory();
                break;
            case CASSANDRA :
                throw new RuntimeException(Messages.DAOFactory.TECHNICAL_CASSANDRA_NOT_IMPLEMENTED);
            case MARIADB :
                throw new RuntimeException(Messages.DAOFactory.TECHNICAL_MARIADB_NOT_IMPLEMENTED);
            case MONGODB :
                throw new RuntimeException(Messages.DAOFactory.TECHNICAL_MONGODB_NOT_IMPLEMENTED);
            case MYSQL :
                throw new RuntimeException(Messages.DAOFactory.TECHNICAL_MYSQL_NOT_IMPLEMENTED);
            case ORACLE :
                throw new RuntimeException(Messages.DAOFactory.TECHNICAL_ORACLE_NOT_IMPLEMENTED);
            case POSTGRESQL :
                throw new RuntimeException(Messages.DAOFactory.TECHNICAL_POSTGRESQL_NOT_IMPLEMENTED);
            default:
                throw new RuntimeException(Messages.DAOFactory.TECHNICAL_UNEXPECTED_DAOFACTORY);
        }
        return daoFactory;
    }

    protected abstract void openConnection();
    public abstract void initTransaction();
    public abstract void confirmTransaction();
    public abstract void cancelTransaction();
    public abstract void closeConnection();

    public abstract CourseDAO getCourseDAO();
    public abstract MonitorDAO getMonitorDAO();
    public abstract MonitoriaDAO getMonitoriaDAO();
    public abstract OfferDAO getOfferDAO();
    public abstract PlaceDAO getPlaceDAO();
    public abstract ReviewDAO getReviewDAO();
    public abstract ScheduleDAO getScheduleDAO();
    public abstract StudentDAO getStudentDAO();
    public abstract TopicDAO getTopicDAO();
;
}
