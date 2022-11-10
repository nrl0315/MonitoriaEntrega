package edu.uco.monitoria.domain.builder;

import edu.uco.monitoria.domain.ScheduleDTO;

import java.util.UUID;

public final class ScheduleDTOBuilder {
    private UUID id;
    private short startDate;
    private short endDate;

    private ScheduleDTOBuilder(){
        super();
    }

    public static final ScheduleDTOBuilder getScheduleDTOBuilder(){
        return new ScheduleDTOBuilder();
    }

    public final ScheduleDTOBuilder setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final ScheduleDTOBuilder setStartDate(final short startDate) {
        this.startDate = startDate;
        return this;
    }

    public final ScheduleDTOBuilder setEndDate(final short endDate) {
        this.endDate = endDate;
        return this;
    }

    public final ScheduleDTO build(){
        return ScheduleDTO.create(id,startDate,endDate);
    }
}
