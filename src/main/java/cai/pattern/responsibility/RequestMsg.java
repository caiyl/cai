package cai.pattern.responsibility;

/**
 * Created by caiyl on 2018/6/9.
 */
public class RequestMsg {

    /**
     * 申请金额
     */
    private int applyMoney;

    public RequestMsg(int applyMoney) {
        this.applyMoney = applyMoney;
    }

    public int getApplyMoney() {
        return applyMoney;
    }

    public void setApplyMoney(int applyMoney) {
        this.applyMoney = applyMoney;
    }
}
