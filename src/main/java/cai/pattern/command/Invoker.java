package cai.pattern.command;

/**
 * Created by caiyl on 2018/6/9.
 * 请求者
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.execute();
    }
}
