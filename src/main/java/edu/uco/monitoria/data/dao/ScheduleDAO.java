package edu.uco.monitoria.data.dao;

import edu.uco.monitoria.domain.ScheduleDTO;

import java.util.List;

public interface ScheduleDAO {
    void create(final ScheduleDTO schedule);
    void update(final ScheduleDTO schedule);
    List<ScheduleDTO> find(final ScheduleDTO schedule);
    void delete(ScheduleDTO schedule);
}
