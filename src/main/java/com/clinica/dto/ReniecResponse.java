package com.clinica.dto;

public class ReniecResponse {

    private boolean success;
    private ReniecData data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ReniecData getData() {
        return data;
    }

    public void setData(ReniecData data) {
        this.data = data;
    }
}
