package edu.uco.monitoria.data.dao.relational.sqlserver;

import edu.uco.monitoria.crosscuting.messages.Messages;

import java.sql.Connection;

import static edu.uco.monitoria.crosscuting.helper.SqlConnectionHelper.connectionIsOpen;

public class DAORelational {
    private Connection connection;
    protected DAORelational(final Connection connection){
        if(!connectionIsOpen(connection)){
            throw new RuntimeException(Messages.SqlConnectionHelper.CONNECTION_IS_CLOSED);
        }
        this.connection = connection;
    }

    protected final Connection getConnection(){
        return connection;
    }
}
