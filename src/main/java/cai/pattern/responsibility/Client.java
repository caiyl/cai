package cai.pattern.responsibility;

/**
 * Created by caiyl on 2018/6/9.
 */
public class Client {
    public static void main(String[] args) {
        Handler father = new FatherHandler();
        Handler mother = new MotherHandler();
        father.setHandler(mother);
        father.handleRequest(new RequestMsg(1500));
    }
}
