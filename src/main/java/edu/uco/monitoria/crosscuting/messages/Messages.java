package edu.uco.monitoria.crosscuting.messages;

public class Messages {
    public static class DAOFactory{
        private DAOFactory(){
            super();
        }

        public static final String TECHNICAL_MONGODB_NOT_IMPLEMENTED = "DAOFactory for MONGODB is not implemented yet";
        public static final String TECHNICAL_CASSANDRA_NOT_IMPLEMENTED = "DAOFactory for CASSANDRA is not implemented yet";
        public static final String TECHNICAL_MYSQL_NOT_IMPLEMENTED = "DAOFactory for MYSQL is not implemented yet";
        public static final String TECHNICAL_ORACLE_NOT_IMPLEMENTED = "DAOFactory for ORACLE is not implemented yet";
        public static final String TECHNICAL_MARIADB_NOT_IMPLEMENTED = "DAOFactory for MARIADB is not implemented yet";
        public static final String TECHNICAL_POSTGRESQL_NOT_IMPLEMENTED = "DAOFactory for POSTGESQL is not implemented yet";
        public static final String TECHNICAL_UNEXPECTED_DAOFACTORY = " Unexpected DAOFactory";
    }

    public static class SqlConnectionHelper{
        private SqlConnectionHelper(){
            super();
        }
        public static final String CONNECTION_IS_NULL = "Connection is null";
        public static final String CONNECTION_IS_CLOSED = "The connection is already closed";
        public static final String CONNECTION_IS_ALREADY_CLOSED = "The connection is already closed ";
        public static final String PROBLEM_TRYING_TO_CLOSE_THE_CONNECTION = "There was a problem when trying to close the connection";
        public static final String CONNECTION_IS_CLOSED_FOR_INIT_TRANSACTION = "The connection is closed and the system is unable to process the transaction";
        public static final String PROBLEM_TRYING_TO_INIT_TRANSACTION = "There was an error when trying to initiate the transaction";
        public static final String PROBLEM_TRYING_TO_COMMIT_TRANSACTION = "There was an error when trying to initiate the transaction COMMIT";
        public static final String PROBLEM_TRYING_TO_ROLLBACK_TRANSACTION = "There was an error when trying to initiate the transaction ROLLBACK";
        public static final String CONNECTION_IS_CLOSED_FOR_COMMIT_TRANSACTION = "The connection is closed and the system is unable to process the transaction COMMIT";
        public static final String CONNECTION_IS_CLOSED_FOR_ROLLBACK_TRANSACTION = "The connection is closed and the system is unable to process the transaction ROLLBACK";
    }

    public static class SQLDAOFactory{
        private SQLDAOFactory(){
            super();
        }
        public static final String TECHNICAL_PROBLEM_INIT_TRANSACTION = "There was a problem trying to init transaction";
    }

    public static class UUIDHelper{
        private UUIDHelper(){
            super();
        }

        public static final String TECHNICAL_INVALID_STRING_TO_CREATE_UUID = "There was an error when trying to create the UUID since " +
                "the argument do not match the format";
        public static final String TECHNICAL_UNEXPECTED_ERROR_CREATING_UUID_FROM_STRING = "There is an unexpected problem when trying to " +
                "convert the string to UUID ";
    }

    public static class MonitoriaSqlServerDAO{
        private MonitoriaSqlServerDAO(){
            super();
        }

        public static final String TECHNICAL_ERROR_WHEN_TRYING_TO_CREATE_MONITORIA = "There was an error when trying to create the information" +
                "for the desired monitoria with id ";
        public static final String TECHNICAL_UNEXPECTED_ERROR_WHEN_TRYING_TO_CREATE_MONITORIA = "There was an unexpected error when trying " +
                "to create the monitoria";
        public static final String TECHNICAL_ERROR_WHEN_TRYING_TO_UPDATE_THE_SELECTED_MONITORIA = "There was an error when trying to update " +
                "the selected monitoria, please verify the information with monitoria id ";
        public static final String TECHNICAL_UNEXPECTED_ERROR_WHEN_TRYING_TO_UPDATE_THE_SELECTED_MONITORIA = "There was an unexpected error " +
                "when trying to update the monitoria";
        public static final String TECHNICAL_ERROR_WHEN_TRYING_TO_DELETE_MONITORIA = "There was an error when trying to delete the selected " +
                "monitoria with id ";
        public static final String TECHNICAL_UNEXPECTED_ERROR_WHEN_TRYING_TO_DELETE_MONITORIA = "There was an unexpected error when trying " +
                "to delete the selected monitoria";
        public static final String TECHNICAL_ERROR_CREATING_MONITOR = "There was an error when trying to create the desired monitor " +
                "with the id ";
        public static final String TECHNICAL_UNEXPECTED_ERROR_CREATING_MONITOR = "There was an unknown error when trying to create the monitor";
        public static final String TECHNICAL_ERROR_TRYING_TO_CREATE_PLACE = "There was an error when trying to create the place with the id ";
        public static final String TECHNICAL_UNEXPECTED_ERROR_WHEN_TRYING_TO_CREATE_THE_PLACE = "There was an unknown " +
                "error when trying to create the place";
        public static final String TECHNICAL_ERROR_TRYING_TO_CREATE_STUDENT = "There was an error when trying to create " +
                "the desired student with the ID ";
        public static final String TECHNICAL_UNEXPECTED_ERROR_WHEN_TRYING_TO_CREATE_STUDENT = "There was an unknown " +
                "error when trying to create the student";
    }

}
