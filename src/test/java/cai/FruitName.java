package cai;

import java.lang.annotation.*;

/**
 * Created by caiyl on 2017/3/30.
 */
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitName {
    String value();
}
