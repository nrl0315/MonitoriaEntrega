package edu.uco.monitoria.crosscuting.exception.data;

import edu.uco.monitoria.crosscuting.exception.enumeration.LayerException;

import static edu.uco.monitoria.crosscuting.helper.ObjectHelper.getDefault;
import static edu.uco.monitoria.crosscuting.helper.StringHelper.applyTrim;
import static sun.util.locale.LocaleUtils.isEmpty;

public class MonitoriaCustomException extends RuntimeException {
    private static final long serialVersionUID = -1664115099034021355l;
    private String userMessage;
    private LayerException layer;

    protected MonitoriaCustomException(final String userMessage,final String technicalMessage, final Throwable rootException,
                                       final LayerException layer){
        super(applyTrim(technicalMessage), getDefault(rootException, new Exception()));
        setUserMessage(userMessage);
        setLayer(layer);
    }

    public MonitoriaCustomException(String userMessage) {
    }

    private final void setUserMessage(final String userMessage){
        this.userMessage = applyTrim(userMessage);
    }

    private final void setLayer(final LayerException layer){
        this.layer = getDefault(layer,LayerException.APPLICATION);
    }

    public final String getUserMessage(){
        return userMessage;
    }

    public final LayerException getLayer(){
        return layer;
    }

    public final boolean isTechnicalException(){
        return isEmpty(getUserMessage());
    }
}
