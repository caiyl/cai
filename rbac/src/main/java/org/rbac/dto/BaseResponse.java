package org.rbac.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class BaseResponse implements Serializable {

    private boolean success = true;
    private String messageCode;
    private String message;
    private Object data;

    public static BaseResponse resultFail(String messageCode, String message){
        BaseResponse retBean=new BaseResponse();
        retBean.setSuccess(false);
        retBean.setMessageCode(messageCode);
        retBean.setMessage(message);
        return retBean;
    }
}
