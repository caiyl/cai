package com.chase.service.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author chase singleton prototype
 * @date 2023/3/20 9:47 AM
 */
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ServiceEEE {
    @Autowired
    private ServiceFFF serviceFFF;
}
