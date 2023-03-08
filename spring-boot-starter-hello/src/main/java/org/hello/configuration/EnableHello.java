package org.hello.configuration;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author chase
 * @date 2023/3/8 4:09 PM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(HelloConfiguration.class)
public @interface EnableHello {
}
