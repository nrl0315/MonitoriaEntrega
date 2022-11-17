package edu.uco.monitoria.monitoriaapi.controller.response;


import edu.uco.monitoria.crosscuting.helper.ObjectHelper;
import edu.uco.monitoria.crosscuting.messages.Enumeration.Message;

import java.util.ArrayList;
import java.util.List;

public class Response <T>{
    private List<Message> messages;
    private List<T> data;

    public Response(List<Message> messages, List<T> data) {
        super();
        setMessages(messages);
        setData(data);
    }
    public Response() {
        setData(new ArrayList<>());
        setMessages(new ArrayList<>());

    }
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(final List<Message> messages) {
        this.messages = ObjectHelper.getDefault(messages, new ArrayList<>());
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = ObjectHelper.getDefault(data, new ArrayList<>());;
    }

    public void addFatalMessages(String content) {
        getMessages().add(Message.createFatalMessage(content));
    }

    public void addWarninglMessages(String content) {
        getMessages().add(Message.createWarningMessage(content));
    }

    public void addInfolMessages(String content) {
        getMessages().add(Message.createInfoMessage(content));
    }
    public void addSuccesMessages(String content) {
        getMessages().add(Message.createSuccesMessage(content));
    }
    public void addErrorMessages(String content) {
        getMessages().add(Message.createErrorMessage(content));
    }
}
