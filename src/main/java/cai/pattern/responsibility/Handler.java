package cai.pattern.responsibility;

/**
 * Created by caiyl on 2018/6/9.
 */
public abstract class Handler {
    protected Handler handler;

    abstract void handleRequest(RequestMsg req);

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
