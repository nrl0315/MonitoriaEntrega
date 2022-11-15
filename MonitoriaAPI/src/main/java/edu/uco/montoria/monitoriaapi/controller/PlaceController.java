package edu.uco.montoria.monitoriaapi.controller;

import edu.uco.monitoria.crosscuting.exception.data.MonitoriaCustomException;
import edu.uco.monitoria.crosscuting.messages.Enumeration.Message;
import edu.uco.monitoria.domain.PlaceDTO;
import edu.uco.monitoria.domain.StudentDTO;
import edu.uco.monitoria.service.command.CreatePlaceCommand;
import edu.uco.monitoria.service.command.implementation.CreatePlaceCommandImpl;
import edu.uco.montoria.monitoriaapi.controller.response.Response;
import edu.uco.montoria.monitoriaapi.controller.validator.Validator;
import edu.uco.montoria.monitoriaapi.controller.validator.place.CreatePlaceValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/place")
public class PlaceController {

    public CreatePlaceCommand createPlaceCommand = new CreatePlaceCommandImpl();

    @GetMapping("/dummy")
    public StudentDTO holaMundo() {
        return new StudentDTO();
    }

    @PostMapping
    public ResponseEntity<Response<PlaceDTO>> create(@RequestBody PlaceDTO place) {

        final Response<PlaceDTO> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            Validator<PlaceDTO> validator = new CreatePlaceValidator();
            List<Message> messages = validator.validate(place);

            if(messages.isEmpty()) {
                createPlaceCommand.execute(place);
            }

            final List<PlaceDTO> data = new ArrayList<>();
            data.add(place);
            response.setData(data);

            response.addSuccesMessages("The budget has been create succesfully");
        } catch (final MonitoriaCustomException exception) {
            if(exception.isTechnicalException()) {
                response.addErrorMessages("There was an error trying to create the budget. Please try again...");
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
            response.addFatalMessages("Thera was a unexpected error trying to create budget. Please try again...");

            //Imprimiendo traza de la excepcion
            exception.printStackTrace();
        }

        return new ResponseEntity<>(response, httpStatus);
    }
}
