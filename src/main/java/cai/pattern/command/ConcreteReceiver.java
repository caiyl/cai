package cai.pattern.command;

/**
 * Created by caiyl on 2018/6/9.
 */
public class ConcreteReceiver implements Receiver {
    @Override
    public void action() {
        System.out.println("action has been taken.");
    }
}
