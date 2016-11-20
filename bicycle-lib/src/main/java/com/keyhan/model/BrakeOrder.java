package com.keyhan.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

/**
 * Created by keyhan on 2016-11-02.
 */
@JsonDeserialize(builder = BrakeOrder.BrakeOrderBuilder.class)
@Builder
@Value
public class BrakeOrder {
    private String orderId;
    private BrakeType brakeType;
    private int numberOfOrders;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class BrakeOrderBuilder {
    }

}
