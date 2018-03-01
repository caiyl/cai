package cai.demo;

/**
 * Created by caiyl on 2018/3/1.
 * Switch语句中用枚举
 */
public class TrafficLight {

    public static void change(Signal color) {
        switch (color) {
            case RED:
                System.out.println(color);
                break;
            case YELLOW:
                System.out.println(color);
                break;
            case GREEN:
                System.out.println(color);
                break;
        }
    }


    public static void main(String[] args) {
        change(Signal.RED);
    }
}