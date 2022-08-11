package com.sparta.rp.exceptions;

public class ChildNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "No child found";
    }
}
