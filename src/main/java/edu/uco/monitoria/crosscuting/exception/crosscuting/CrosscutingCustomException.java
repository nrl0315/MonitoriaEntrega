package edu.uco.monitoria.crosscuting.exception.crosscuting;

import edu.uco.monitoria.crosscuting.exception.data.MonitoriaCustomException;
import edu.uco.monitoria.crosscuting.exception.enumeration.LayerException;

import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;

public final class CrosscutingCustomException extends MonitoriaCustomException {
    private static final long serialVersionUID = 6955662894932198270l;

    public CrosscutingCustomException(final String userMessage, final String technicalMessage, final Exception rootException){
        super(userMessage,technicalMessage,rootException,LayerException.CROSSCUTING);
    }


    public static final MonitoriaCustomException createUserException(final String userMessage, final String technicalMessage,
                                                                  final Exception rootException){
        return new CrosscutingCustomException(userMessage,userMessage,new Exception());
    }

    public static final MonitoriaCustomException createTechnicalException(final String technicalMessage, final Exception exception){
        return new CrosscutingCustomException(EMPTY, technicalMessage,new Exception());
    }

    public static final MonitoriaCustomException create(final String userMessage, final String technicalMessage, final Exception exception){
        return new CrosscutingCustomException(userMessage,technicalMessage,new Exception());
    }
}
