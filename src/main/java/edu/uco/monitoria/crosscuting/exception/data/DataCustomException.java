package edu.uco.monitoria.crosscuting.exception.data;

import edu.uco.monitoria.crosscuting.exception.enumeration.LayerException;

import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;

public class DataCustomException extends MonitoriaCustomException{
    private static final long serialVersionUID = 7955662894932198270l;
    protected DataCustomException(final String userMessage, final String technicalMessage, Exception rootException) {
        super(userMessage, technicalMessage, rootException, LayerException.DATA);
    }

    public static final MonitoriaCustomException createUserException(final String userMessage, final String technicalMessage,
                                                                  final Exception rootException){
        return new DataCustomException(userMessage,userMessage,new Exception());
    }

    public static final MonitoriaCustomException createTechnicalException(final String technicalMessage, final Exception exception){
        return new DataCustomException(EMPTY, technicalMessage,new Exception());
    }

    public static final MonitoriaCustomException create(final String userMessage, final String technicalMessage, final Exception exception){
        return new DataCustomException(userMessage,technicalMessage,new Exception());
    }
}
