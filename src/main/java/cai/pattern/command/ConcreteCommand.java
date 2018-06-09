package cai.pattern.command;

/**
 * Created by caiyl on 2018/6/9.
 * 具体命令实现
 */
public class ConcreteCommand implements Command {

    //命令接受者
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    //命令调用接收者的行为
    @Override
    public void execute() {
        receiver.action();
    }
}
