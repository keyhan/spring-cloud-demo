package com.keyhan.bikeassembly.controller;

import com.keyhan.bikeassembly.service.OrderService;
import com.keyhan.model.Bicycle;
import com.keyhan.model.BicycleOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/bicycle")
public class BicycleController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping(path="/order",method= RequestMethod.POST)
	public Bicycle assembleOrder(@RequestBody BicycleOrder order) {
		return orderService.handleOrder(order);
	}

}
