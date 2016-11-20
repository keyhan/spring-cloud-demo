package com.keyhan.brakessupplier.controller;

import com.keyhan.model.Brake;
import com.keyhan.model.BrakeOrder;
import com.keyhan.model.BrakeType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keyhan on 2016-11-13.
 */
@RestController
public class BrakeController {

    @RequestMapping(method = RequestMethod.POST, path="/brake",consumes= MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public Brake handleOrder(@RequestBody BrakeOrder brakeOrder) {
        return Brake.builder().brakeType(BrakeType.Disc)
                    .manufacturer("Shimanu").model("101").build();
    }
}
