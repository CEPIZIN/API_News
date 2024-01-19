package main;

public class BadRequestException extends NullPointerException {
    public BadRequestException(String message) {
        super(message);
    }
}
