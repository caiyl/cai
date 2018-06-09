package cai.pattern.responsibility;

/**
 * Created by caiyl on 2018/6/9.
 */
public class FatherHandler extends Handler {
    private Handler nextHandler;
    @Override
    void handleRequest(RequestMsg req) {
        if(req.getApplyMoney() < 1000){
            System.out.println("father handler");
        }else if(nextHandler != null){
            nextHandler.handleRequest(req);
        }else{
            System.out.println("not body can not handler");
        }
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
