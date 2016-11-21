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
@JsonDeserialize(builder = SaddleOrder.SaddleOrderBuilder.class)
public class SaddleOrder {
    int nOrders;
    String type;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class SaddleOrderBuilder{}
}
