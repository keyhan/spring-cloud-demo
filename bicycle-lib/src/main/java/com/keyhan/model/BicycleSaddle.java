package com.keyhan.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

/**
 * Created by keyhan on 2016-11-21.
 */
@Builder
@Value
@JsonDeserialize(builder = BicycleSaddle.BicycleSaddleBuilder.class)
public class BicycleSaddle {
    private String name;

    private String model;

    private int size;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class BicycleSaddleBuilde {}
}
