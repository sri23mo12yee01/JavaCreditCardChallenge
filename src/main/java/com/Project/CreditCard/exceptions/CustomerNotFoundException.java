package com.Project.CreditCard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception{
    private String resourceName;
    private Object fieldValue;
    private String fieldName;
    public CustomerNotFoundException(String message) {
        super(message);
    }
    public CustomerNotFoundException( String _resourceName, String _fieldName, Object _fieldValue) {
        super(String.format("%s not found with %s : '%s'", _resourceName, _fieldName, _fieldValue));
        this.resourceName = _resourceName;
        this.fieldName = _fieldName;
        this.fieldValue = _fieldValue;
    }
}

