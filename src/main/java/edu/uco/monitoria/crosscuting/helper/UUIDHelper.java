package edu.uco.monitoria.crosscuting.helper;

import edu.uco.monitoria.crosscuting.exception.crosscuting.CrosscutingCustomException;
import edu.uco.monitoria.crosscuting.messages.Messages;

import java.util.UUID;

public final class UUIDHelper {
    private static final  String DEFAULT_UUID_AS_STRING = "00000000-0000-0000-0000-000000000000";
    private static final UUID DEFAULT_UUID = UUID.fromString(DEFAULT_UUID_AS_STRING);
    private UUIDHelper(){
        super();
    }

    public static final UUID getDefaultUUID(final UUID value){
        return ObjectHelper.getDefault(value,getNewUUID());
    }

    public static final UUID getNewUUID(){
        return UUID.randomUUID();
    }

    public static final String getUUIDAsString(final UUID value){
        return getDefaultUUID(value).toString();
    }

    public static final UUID getUUIDFromString(final String value){
        try{
            return UUID.fromString(StringHelper.getDefaultString(value,DEFAULT_UUID_AS_STRING));
        } catch(IllegalArgumentException exception){
            throw CrosscutingCustomException.createTechnicalException(Messages.UUIDHelper.TECHNICAL_INVALID_STRING_TO_CREATE_UUID,exception);
        } catch(Exception exception){
            throw CrosscutingCustomException.createTechnicalException(Messages.UUIDHelper.TECHNICAL_UNEXPECTED_ERROR_CREATING_UUID_FROM_STRING,exception);
        }
    }
}
