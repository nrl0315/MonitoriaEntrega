package edu.uco.monitoria.service.usecase.monitor.implementation;

import edu.uco.monitoria.crosscuting.exception.usecase.UseCaseCustomException;
import edu.uco.monitoria.crosscuting.helper.UUIDHelper;
import edu.uco.monitoria.crosscuting.messages.Messages;
import edu.uco.monitoria.data.daofactory.DAOFactory;
import edu.uco.monitoria.domain.MonitorDTO;
import edu.uco.monitoria.service.usecase.monitor.CreateMonitorUseCase;

import java.util.List;

public class CreateMonitorUseCaseImpl implements CreateMonitorUseCase {
    private final DAOFactory factory;
    private final FindMonitorByIdImpl findMonitor;

    public CreateMonitorUseCaseImpl(DAOFactory factory){
        this.factory = factory;
        findMonitor = new FindMonitorByIdImpl(factory);
    }

    @Override
    public void execute(MonitorDTO monitor) {
        monitor.setId(UUIDHelper.getNewUUID());
        monitor.setName(monitor.getName());
        monitor.setSurname(monitor.getSurname());
        monitor.setEmail(monitor.getEmail());
        monitor.setPhoneNumber(monitor.getPhoneNumber());
        monitor.setDegree(monitor.getDegree());
        monitor.setNote(monitor.getNote());
        factory.getMonitorDAO().create(monitor);
    }

    private final void validateIfMonitorExist(MonitorDTO monitor){
        final List<MonitorDTO> results = findMonitor.execute(monitor);
        if(!results.isEmpty()){
            throw UseCaseCustomException.createUserException(Messages.CreateStudentUseCaseImpl.BUSSINES_MONITOR_ALREADY_EXISTS);
        }
    }
}
