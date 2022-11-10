package edu.uco.monitoria.data.dao.relational;

import edu.uco.monitoria.domain.MonitoriaDTO;

import java.util.List;

public interface MonitoriaDAO {
    void create(final MonitoriaDTO monitoria);
    void update(final MonitoriaDTO monitoria);
    List<MonitoriaDTO> find(final MonitoriaDTO monitoria);
    void delete(MonitoriaDTO monitoria);
}
