package com.keyhan.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

/**
 * Created by keyhan on 2016-11-02.
 */

@Builder
@Value
@JsonDeserialize(builder = HandleBar.HandleBarBuilder.class)
public class HandleBar {
    private String Manufacturer;
    private HandlebarType type;
    private String model;
    private int size;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class HandleBarBuilder {}
}
