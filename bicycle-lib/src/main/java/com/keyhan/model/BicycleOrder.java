package com.keyhan.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

@Builder
@Value
@JsonDeserialize(builder = BicycleOrder.BicycleOrderBuilder.class)
public class BicycleOrder {
	private int numberOfOrders;
    private String color;
	private String orderId;
	private BicycleSize size;
	private int gears;
	private BrakeType brake;
	private HandlebarType handleBar;
	private String model;
    @JsonPOJOBuilder(withPrefix = "")
    public static final class BicycleOrderBuilder {}
}
