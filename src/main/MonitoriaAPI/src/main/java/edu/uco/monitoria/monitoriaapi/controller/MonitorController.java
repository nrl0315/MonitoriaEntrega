package edu.uco.monitoria.monitoriaapi.controller;

import edu.uco.monitoria.crosscuting.exception.data.MonitoriaCustomException;
import edu.uco.monitoria.crosscuting.messages.Enumeration.Message;
import edu.uco.monitoria.domain.MonitorDTO;
import edu.uco.monitoria.monitoriaapi.controller.response.Response;
import edu.uco.monitoria.monitoriaapi.controller.validator.Validator;
import edu.uco.monitoria.monitoriaapi.controller.validator.monitor.CreateMonitorValidator;
import edu.uco.monitoria.service.command.CreateMonitorCommand;
import edu.uco.monitoria.service.command.implementation.CreateMonitorCommandImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/monitor")
public class MonitorController {
    public CreateMonitorCommand createMonitorCommand = new CreateMonitorCommandImpl();

    @GetMapping("/dummy")
    public MonitorDTO monitor() {
        return new MonitorDTO();
    }

    @PostMapping
    public ResponseEntity<Response<MonitorDTO>> create(@RequestBody MonitorDTO monitor) {

        final Response<MonitorDTO> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            Validator<MonitorDTO> validator = new CreateMonitorValidator();
            List<Message> messages = validator.validate(monitor);

            if(messages.isEmpty()) {
                createMonitorCommand.execute(monitor);
            }

            final List<MonitorDTO> data = new ArrayList<>();
            data.add(monitor);
            response.setData(data);

            response.addSuccesMessages("The monitor has been create succesfully");
        } catch (final MonitoriaCustomException exception) {
            if(exception.isTechnicalException()) {
                response.addErrorMessages("There was an error trying to create the monitor. Please try again...");
            }else {
                //Error 400
                httpStatus = HttpStatus.BAD_REQUEST;
                response.addErrorMessages(exception.getMessage());

            }

            //Imprimiendo traza de la excepcion
            exception.printStackTrace();
        } catch (final Exception exception) {
            //Error 500
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response.addFatalMessages("Thera was a unexpected error trying to create Monitor. Please try again...");

            //Imprimiendo traza de la excepcion
            exception.printStackTrace();
        }

        return new ResponseEntity<>(response, httpStatus);
    }
}
