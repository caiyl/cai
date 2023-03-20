package com.chase.service.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chase
 * @date 2023/3/20 9:40 AM
 */
@Service
public class ServiceCCC {
    private ServiceDDD serviceDDD;

    public ServiceCCC(@Autowired ServiceDDD serviceDDD) {
        this.serviceDDD = serviceDDD;
    }
}
