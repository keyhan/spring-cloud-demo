package com.keyhan.bikeassembly.client;

import com.keyhan.model.Brake;
import com.keyhan.model.BrakeOrder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("BRAKESSUPPLIER")
public interface BrakeClient {

    @HystrixCommand(fallbackMethod = "orderBrake2")
    @RequestMapping(method = RequestMethod.POST, path="/brake",consumes= MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public Brake orderBrake(@RequestBody BrakeOrder brakeOrder);

}
