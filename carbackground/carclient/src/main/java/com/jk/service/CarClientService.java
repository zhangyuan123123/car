package com.jk.service;

import com.jk.common.ThisClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "carservice",fallbackFactory = ThisClientHystrix.class)
public interface CarClientService {

    String refer();
}
