package org.acme;

public class ResponseHello {
    String message;

    public ResponseHello(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
