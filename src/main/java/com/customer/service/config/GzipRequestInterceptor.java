package com.customer.service.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class GzipRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("Accept-Encoding", "gzip");
    }
}
