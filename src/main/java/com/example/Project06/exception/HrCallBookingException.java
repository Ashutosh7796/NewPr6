package com.example.Project06.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HrCallBookingException extends RuntimeException{

    public HrCallBookingException(String s) {
    }

    public HrCallBookingException(String s, String EventBookingException) {
    }
}
