package com.keyhan.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

/**
 * Created by keyhan on 2016-11-02.
 */

@Builder
@Value
@JsonDeserialize(builder = Brake.BrakeBuilder.class)
public class Brake {
    private String manufacturer;
    private BrakeType brakeType;
    private String model;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class BrakeBuilder {}
}
