package com.taxy.exception;

public class TaxActivityNotFoundException extends RuntimeException {

    public TaxActivityNotFoundException(Long id) {
        super("Tax activity not found with id: " + id);
    }
}