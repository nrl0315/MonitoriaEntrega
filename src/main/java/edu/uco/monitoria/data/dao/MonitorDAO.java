package edu.uco.monitoria.data.dao;

import edu.uco.monitoria.domain.MonitorDTO;

import java.util.List;

public interface MonitorDAO {
    void create(final MonitorDTO monitor);
    void update(final MonitorDTO monitor);
    List<MonitorDTO> find(final MonitorDTO monitor);
    void delete(MonitorDTO monitor);
}
