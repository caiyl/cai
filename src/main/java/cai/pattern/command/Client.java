package cai.pattern.command;

/**
 * Created by caiyl on 2018/6/9.
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new ConcreteReceiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
