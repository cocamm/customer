package com.customer.service.converter;

public interface Converter<T, K> {

    K convert(T t);
}
