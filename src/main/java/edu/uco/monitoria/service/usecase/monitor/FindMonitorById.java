package edu.uco.monitoria.service.usecase.monitor;

import edu.uco.monitoria.domain.MonitorDTO;

import java.util.List;
import java.util.UUID;

public interface FindMonitorById {
    List<MonitorDTO> execute (MonitorDTO monitor);
}
