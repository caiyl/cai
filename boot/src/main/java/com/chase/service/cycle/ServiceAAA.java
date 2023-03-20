package com.chase.service.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chase
 * @date 2023/3/20 9:37 AM
 */
@Service
public class ServiceAAA {
    @Autowired
    private ServiceBBB serviceBBB;
}
