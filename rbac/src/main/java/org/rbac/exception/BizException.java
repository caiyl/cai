package org.rbac.exception;



/**
 * @author xty
 * Created by xty on 2021/3/28.
 * @since 1.0
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1435337124062489197L;

    private BizCode bizCode;

    public BizException(BizCode bizCode) {
        this.bizCode = bizCode;
    }

    public BizException(String detailMessage, BizCode bizCode) {
        super(detailMessage);
        this.bizCode = bizCode;
    }

    public BizException(String message, Throwable cause, BizCode bizCode) {
        super(message, cause);
        this.bizCode = bizCode;
    }

    public BizException(Throwable cause, BizCode bizCode) {
        super(cause);
        this.bizCode = bizCode;
    }

    public BizCode getBizCode() {
        return bizCode;
    }
}
