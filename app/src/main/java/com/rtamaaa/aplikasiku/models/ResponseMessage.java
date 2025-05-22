package com.rtamaaa.aplikasiku.models;

public class ResponseMessage {
    private boolean success;
    private String message;
    private User data;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public User getData() { return data; }
}
