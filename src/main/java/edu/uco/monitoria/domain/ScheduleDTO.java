package edu.uco.monitoria.domain;

import edu.uco.monitoria.crosscuting.helper.UUIDHelper;

import java.util.Date;
import java.util.UUID;
import static edu.uco.monitoria.crosscuting.helper.DateHelper.getDefaultDate;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getUUIDFromString;

public final class ScheduleDTO {
    private UUID id;
    private short startDate;
    private short endDate;

    public ScheduleDTO(){
        setId(getDefaultUUID(id));
        setStartDate(getDefaultDate(startDate));
        setEndDate(getDefaultDate(endDate));
    }

    public ScheduleDTO(UUID id, short startDate, short endDate) {
        setId(getDefaultUUID(id));
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public static final ScheduleDTO create(final UUID id, final short startDate, final short endDate){
        return new ScheduleDTO(id,startDate,endDate);
    }

    public static final ScheduleDTO create(final String id,final short startDate, final short endDate ){
        return new ScheduleDTO(getUUIDFromString(id),startDate,endDate);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }

    public short getStartDate() {
        return startDate;
    }

    public void setStartDate(short startDate) {
        this.startDate = startDate;
    }

    public short getEndDate() {
        return endDate;
    }

    public void setEndDate(short endDate) {
        this.endDate = endDate;
    }

    public final String getUUIDAsString(){
        return UUIDHelper.getUUIDAsString(getId());
    }
}
