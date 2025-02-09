package net.javaguides.spring_user_rest_service.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    private String message;

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
