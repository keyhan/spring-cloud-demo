package com.keyhan.brakessupplier.controller;

import com.keyhan.model.Brake;
import com.keyhan.model.BrakeOrder;
import com.keyhan.model.BrakeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by keyhan on 2016-11-13.
 */
@RestController
@Slf4j
public class BrakeController {

    @RequestMapping(method = RequestMethod.POST, path="/brake",consumes= MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public Brake handleOrder(@RequestBody BrakeOrder brakeOrder) throws UnknownHostException, InterruptedException {

        InetAddress ip = InetAddress.getLocalHost();

        log.info("new brake order recieved: "+ brakeOrder);
        log.info("this server hostname is: " + ip.getHostName());

        Thread.sleep(1000);
        return Brake.builder().brakeType(BrakeType.Disc)
                    .manufacturer("Keyhanu").model("101").build();

    }
}
