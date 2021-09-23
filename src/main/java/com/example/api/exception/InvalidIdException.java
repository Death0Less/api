package com.example.api.exception;

public class InvalidIdException extends RuntimeException {

    private int id;
    private String method;

    public InvalidIdException(int id, String method) {
        this.id = id;
        this.method = method;
    }

    public InvalidIdException(String message, int id, String method) {
        super(message);
        this.id = id;
        this.method = method;
    }

    public InvalidIdException(String message, Throwable cause, int id, String method) {
        super(message, cause);
        this.id = id;
        this.method = method;
    }

    public InvalidIdException(Throwable cause, int id, String method) {
        super(cause);
        this.id = id;
        this.method = method;
    }

    public InvalidIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int id, String method) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.id = id;
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }
}
