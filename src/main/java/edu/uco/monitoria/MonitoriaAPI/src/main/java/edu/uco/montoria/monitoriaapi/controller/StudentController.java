package edu.uco.montoria.monitoriaapi.controller;

import edu.uco.monitoria.crosscuting.exception.data.MonitoriaCustomException;
import edu.uco.monitoria.crosscuting.messages.Enumeration.Message;
import edu.uco.monitoria.domain.StudentDTO;
import edu.uco.monitoria.service.command.CreateStudentCommand;
import edu.uco.monitoria.service.command.implementation.CreateStudentCommandImpl;
import edu.uco.montoria.monitoriaapi.controller.response.Response;
import edu.uco.montoria.monitoriaapi.controller.validator.Validator;
import edu.uco.montoria.monitoriaapi.controller.validator.student.CreateStudentValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/student")
public class StudentController {
    public CreateStudentCommand createStudentCommand = new CreateStudentCommandImpl();

    @GetMapping("/dummy")
    public StudentDTO holaMundo() {
        return new StudentDTO();
    }

    @PostMapping
    public ResponseEntity<Response<StudentDTO>> create(@RequestBody StudentDTO student) {

        final Response<StudentDTO> response = new Response<>();
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            Validator<StudentDTO> validator = new CreateStudentValidator();
            List<Message> messages = validator.validate(student);

            if(messages.isEmpty()) {
                createStudentCommand.execute(student);
            }

            final List<StudentDTO> data = new ArrayList<>();
            data.add(student);
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
