package com.shop.Exceptions;

public class NoEntityException extends Exception {
    private int number;
    public int getNumber(){return number;}

    public NoEntityException(Long id, String message){
        super(message);
    }
}
