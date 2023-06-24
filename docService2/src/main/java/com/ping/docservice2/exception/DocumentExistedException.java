package com.ping.docservice2.exception;

public class DocumentExistedException extends RuntimeException{
    public DocumentExistedException(String message){
        super(message);
    }
}
