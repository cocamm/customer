package com.customer.service.config;

import com.customer.service.exception.BadRequestException;
import com.customer.service.exception.InternalServerErrorException;
import com.customer.service.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

import static feign.FeignException.errorStatus;

public class DefaultErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 404) {
            return new NotFoundException();
        }
        if (response.status() >= 400 && response.status() <= 499) {
            return new BadRequestException(response.reason());
        }
        if (response.status() >= 500 && response.status() <= 599) {
            return new InternalServerErrorException("Internal server error");
        }

        return errorStatus(methodKey, response);
    }
}
