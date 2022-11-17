package edu.uco.monitoria.monitoriaapi.controller.validator.student;

import edu.uco.monitoria.crosscuting.helper.UUIDHelper;
import edu.uco.monitoria.crosscuting.messages.Enumeration.Message;
import edu.uco.monitoria.domain.StudentDTO;
import edu.uco.monitoria.monitoriaapi.controller.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateStudentValidator implements Validator<StudentDTO> {
    @Override
    public List<Message> validate(StudentDTO dto) {
        List<Message> messages = new ArrayList<>();

        validateStudentId(dto.getId(), messages);

        return messages;
    }

    private void validateStudentId(UUID studentId, List<Message> messages) {

        if(UUIDHelper.isDefaultUUID(studentId)) {
            messages.add(Message.createErrorMessage("student id is equal to default value"));
        }

    }
}
