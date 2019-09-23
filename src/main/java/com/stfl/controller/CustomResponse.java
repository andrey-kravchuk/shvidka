package com.stfl.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomResponse<T> {

    private int statusCode;
    private T body;
    private List<String> messages = new ArrayList<>();

    public void addMessage(String message) {
        messages.add(message);
    }

    public void responseWithOK(T body){
        this.statusCode = HttpStatus.OK.value();
        this.body = body;
//        addMessage(HttpStatus.OK.getReasonPhrase());
    }

    public void responseWithCreated(T body){
        this.statusCode = HttpStatus.CREATED.value();
        this.body = body;
//        addMessage(HttpStatus.CREATED.getReasonPhrase());
    }
}
