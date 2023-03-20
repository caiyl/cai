package com.chase.service.cycle;

import org.springframework.stereotype.Service;

/**
 * @author chase
 * @date 2023/3/20 9:40 AM
 */
@Service
public class ServiceDDD {

    private ServiceCCC serviceCCC;
//    构造器循环依赖
//    public ServiceDDD(@Autowired ServiceCCC serviceCCC) {
//        this.serviceCCC = serviceCCC;
//    }
}
