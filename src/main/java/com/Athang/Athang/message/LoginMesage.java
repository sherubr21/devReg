package com.Athang.Athang.message;

public class LoginMesage{
    String message;

    public LoginMesage(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public LoginMesage() {
    }

    Boolean status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
