package edu.uco.monitoria.service.command;

import edu.uco.monitoria.domain.MonitorDTO;

public interface CreateMonitorCommand {
    void execute (MonitorDTO monitor);
}
