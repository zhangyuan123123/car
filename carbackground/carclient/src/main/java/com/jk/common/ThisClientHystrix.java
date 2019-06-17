package com.jk.common;

import com.jk.service.CarClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ThisClientHystrix implements FallbackFactory<CarClientService> {

    @Override
    public CarClientService create(Throwable throwable) {

        return () -> "错误";
    }
}

