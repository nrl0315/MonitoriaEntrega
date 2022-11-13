package edu.uco.monitoria.service.usecase.monitor;

import edu.uco.monitoria.domain.MonitorDTO;

import java.util.UUID;

public interface FindMonitorById {
    MonitorDTO execute(UUID id);
}
