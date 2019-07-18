package com.customer.service.exception;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorMessage {

    private int code;
    private List<String> errors;
}
