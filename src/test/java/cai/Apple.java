package cai;

import java.lang.reflect.Field;

/**
 * Created by caiyl on 2017/3/30.
 */
public class Apple {
    @FruitName(value = "apple")
    private String appleName;

    private String code;


    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static void main(String[] args) {
        Field[] fields = Apple.class.getDeclaredFields();
        for(Field field :fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                System.out.println(fruitName.value());
            }

        }
    }
}
