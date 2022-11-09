package edu.uco.monitoria.crosscuting.helper;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public final class DateHelper {

    private DateHelper(){
        super();
    }

    public static final short getDefaultDate(final short value){
        return ObjectHelper.getDefault(value,getNewDate());
    }

    public static final short getNewDate(){
        return(short) LocalDate.now().getDayOfMonth();
    }

}
