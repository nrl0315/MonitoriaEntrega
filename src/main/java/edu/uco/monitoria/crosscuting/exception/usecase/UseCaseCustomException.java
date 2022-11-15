package edu.uco.monitoria.crosscuting.exception.usecase;

import edu.uco.monitoria.crosscuting.exception.data.MonitoriaCustomException;
import edu.uco.monitoria.crosscuting.exception.enumeration.LayerException;

import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;

public class UseCaseCustomException extends MonitoriaCustomException {
    private static final long serialVersionUID = 7955662894932198270l;
    protected UseCaseCustomException(final String userMessage, final String technicalMessage, final Exception rootException) {
        super(userMessage, technicalMessage,rootException , LayerException.DATA);
    }

    protected UseCaseCustomException(String userMessage) {
        super(userMessage);
    }

    public static final MonitoriaCustomException createUserException(final String userMessage){
        return new UseCaseCustomException(userMessage);
    }

    public static final MonitoriaCustomException createTechnicalException(final String technicalMessage, final Exception exception){
        return new UseCaseCustomException(EMPTY, technicalMessage,new Exception());
    }

    public static final MonitoriaCustomException createBusinessException(final String businessMessage, final Exception exception){
        return new UseCaseCustomException(businessMessage, EMPTY,new Exception());
    }

    public static final MonitoriaCustomException create(final String userMessage, final String technicalMessage, final Exception exception){
        return new UseCaseCustomException(userMessage,technicalMessage,new Exception());
    }

    public static final MonitoriaCustomException wrapException(final String message, final MonitoriaCustomException exception){
        if(exception.isTechnicalException()){
            return UseCaseCustomException.createBusinessException(null,exception);
        }
        return exception;
    }
}
