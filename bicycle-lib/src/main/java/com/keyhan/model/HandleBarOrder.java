package com.keyhan.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

/**
 * Created by keyhan on 2016-11-02.
 */
@Builder
@Value
@JsonDeserialize(builder = HandleBarOrder.HandleBarOrderBuilder.class)
public class HandleBarOrder {
    private String orderId;
    private int numberOfOrders;
    private HandlebarType handlebarType;
    @JsonPOJOBuilder(withPrefix = "")
    public static final class HandleBarOrderBuilder {}
}
