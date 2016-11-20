package com.keyhan.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

/**
 * Created by keyhan on 2016-11-02.
 */
@Builder
@Value
@JsonDeserialize(builder = Bicycle.BicycleBuilder.class)
public class Bicycle {
    private String manufacturer;
    private String model;
    private Brake brake;
    private HandleBar handleBar;
    //private BicycleType bicycleType;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class BicycleBuilder {}
}
