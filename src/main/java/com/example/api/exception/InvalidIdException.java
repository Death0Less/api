package com.example.api.exception;

public class InvalidIdException extends RuntimeException {

    private long id;
    private String message;

    public InvalidIdException(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public InvalidIdException(String message, long id, String message1) {
        super(message);
        this.id = id;
        this.message = message1;
    }

    public InvalidIdException(String message, Throwable cause, long id, String message1) {
        super(message, cause);
        this.id = id;
        this.message = message1;
    }

    public InvalidIdException(Throwable cause, long id, String message) {
        super(cause);
        this.id = id;
        this.message = message;
    }

    public InvalidIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, long id, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.id = id;
        this.message = message1;
    }

    public long getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
