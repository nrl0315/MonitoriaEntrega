package edu.uco.montoria.monitoriaapi.controller.validator;

import edu.uco.monitoria.crosscuting.messages.Enumeration.Message;

import java.util.List;

public interface Validator <T>{
    List<Message> validate(T dto);
}
