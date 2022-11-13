package edu.uco.monitoria.service.usecase.monitor.implementation;

import edu.uco.monitoria.data.daofactory.DAOFactory;
import edu.uco.monitoria.domain.MonitorDTO;
import edu.uco.monitoria.service.usecase.monitor.FindMonitorById;

import java.util.List;
import java.util.UUID;

public class FindMonitorByIdImpl implements FindMonitorById {

    private final DAOFactory factory;

    public FindMonitorByIdImpl(DAOFactory factory){
        this.factory = factory;
    }
    @Override
    public MonitorDTO execute(UUID id) {
        MonitorDTO result = new MonitorDTO();
        final MonitorDTO monitor = MonitorDTO.create(id);
        final List<MonitorDTO> results = factory.getMonitorDAO().find(monitor);

        if(!results.isEmpty()){
            result = results.get(0);
        }
        return null;
    }
}
