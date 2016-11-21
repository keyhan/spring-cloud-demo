package com.keyhan.bikeassembly.service;

import com.keyhan.bikeassembly.client.BrakeClient;
import com.keyhan.model.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderService {

	//@Autowired
	//HandleBarClient handleBarClient;

    @Autowired
    BrakeClient brakeClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;


    public Bicycle handleOrder(BicycleOrder incomingOrder) {
        Bicycle.BicycleBuilder bicycleBuilder =
                Bicycle.builder();

        HandleBar handleBar = null;
//        try {
//            handleBars = handleBarClient.orderHandleBar(createHandleBarOrder(incomingOrder));
//        } catch (Exception e) {
//            log.error("handlebar-supplier service not available", e);
//        }
        Brake brake = null;
        try {
//            ServiceInstance instance = loadBalancerClient.choose("BRAKESSUPPLIER");
//
//            List<ServiceInstance> serviceInstances = discoveryClient.getInstances("BRAKESSUPPLIER");
//
//            for (ServiceInstance serviceInstance : serviceInstances) {
//                System.out.println("serviceInstance = " + serviceInstance);
//            }
//
//            System.out.println("HOST  ====== " + instance.getHost());
//            URI uri = instance.getUri();
//            //String url = uri.
//            System.out.println("URI == " + uri);
            //brakes = new RestTemplate().postForEntity(uri.)

            brake = supplierBrake(createBrakeOrder(incomingOrder));
        } catch (Exception e) {
            log.error("brake-supplier service not available", e);
        }

            if(brake != null) {
                bicycleBuilder.brake(brake);
            }

            if(handleBar != null) {
                bicycleBuilder.handleBar(handleBar);
            }
            bicycleBuilder.manufacturer("MONARK");
            bicycleBuilder.model("101");
        return bicycleBuilder.build();
	}


    private static HandleBarOrder createHandleBarOrder(BicycleOrder incomingOrder) {
        return HandleBarOrder.builder().handlebarType(HandlebarType.City)
                .numberOfOrders(incomingOrder.getNumberOfOrders())
                .orderId(incomingOrder.getOrderId()).build();
    }

    private static BrakeOrder createBrakeOrder(BicycleOrder incomingOrder) {
        return BrakeOrder.builder().numberOfOrders(incomingOrder.getNumberOfOrders())
                .brakeType(BrakeType.Disc).orderId(incomingOrder.getOrderId()).build();
    }

    @HystrixCommand(fallbackMethod = "localBrake")
    public Brake supplierBrake(BrakeOrder brakeOrder) {

        return brakeClient.orderBrake(brakeOrder);
    }

    public Brake localBrake(BrakeOrder brakeOrder) {
        return Brake.builder().model("007")
                .manufacturer("HASSES")
                .brakeType(BrakeType.Foot).build();
    }


}
