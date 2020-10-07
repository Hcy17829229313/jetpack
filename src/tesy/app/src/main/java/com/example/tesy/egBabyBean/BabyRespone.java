package com.example.tesy.egBabyBean;

import com.google.gson.JsonElement;

public class BabyRespone {
    private JsonElement record;
    private int status;
    private JsonElement messages;

    public JsonElement getRecord() {
        return record;
    }

    public void setRecord(JsonElement record) {
        this.record = record;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public JsonElement getMessages() {
        return messages;
    }

    public void setMessages(JsonElement messages) {
        this.messages = messages;
    }
}
