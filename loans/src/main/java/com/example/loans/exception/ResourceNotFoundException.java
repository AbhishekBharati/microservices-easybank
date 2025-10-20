package com.example.loans.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String Resource, String FieldName, String FieldId){
        super(String.format("Not able to find %s with given %s :- %s", Resource, FieldName, FieldId));
    }
}
