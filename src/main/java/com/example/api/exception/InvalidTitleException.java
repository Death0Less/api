package com.example.api.exception;

public class InvalidTitleException extends RuntimeException{

    private String title;
    private String method;

    public InvalidTitleException(String title, String method) {
        this.title = title;
        this.method = method;
    }

    public InvalidTitleException(String message, String title, String method) {
        super(message);
        this.title = title;
        this.method = method;
    }

    public InvalidTitleException(String message, Throwable cause, String title, String method) {
        super(message, cause);
        this.title = title;
        this.method = method;
    }

    public InvalidTitleException(Throwable cause, String title, String method) {
        super(cause);
        this.title = title;
        this.method = method;
    }

    public InvalidTitleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String title, String method) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.title = title;
        this.method = method;
    }

    public String getTitle() {
        return title;
    }

    public String getMethod() {
        return method;
    }
}
