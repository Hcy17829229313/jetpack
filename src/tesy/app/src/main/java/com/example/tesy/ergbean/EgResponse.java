package com.example.tesy.ergbean;

import com.google.gson.JsonElement;

import java.util.List;

public class EgResponse {

    private boolean success;
    private String message;
    private JsonElement data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }
}
