package com.chase.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * @author chase
 * @date 2023/2/24 4:21 PM
 */
@Slf4j
@Service
public class UserServiceFactoryBean implements FactoryBean<UserService> {

    @Override
    public UserService getObject() throws Exception {
        log.info("创建UserService对象");
        return new UserService();
    }

    @Override
    public Class<?> getObjectType() {
        return UserService.class;
    }
}
