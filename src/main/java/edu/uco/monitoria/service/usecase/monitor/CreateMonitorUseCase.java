package edu.uco.monitoria.service.usecase.monitor;

import edu.uco.monitoria.domain.MonitorDTO;

public interface CreateMonitorUseCase {
    void execute(MonitorDTO monitor);
}
