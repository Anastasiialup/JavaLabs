package com.education.ztu;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Invalid password format.");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
