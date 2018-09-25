package com.hb.start_boot.common.enums;

public enum  BusinessMsgEnum {
    PARMETER_EXCEPTION("102", "参数异常!"),
    SERVICE_TIME_OUT("103", "服务调用超时!"),
    PARETER_BIG_OUT("102", "输入的图片数量不能超过50张!"),
    UNEXPECTED_EXCERTION("500", "系统发生异常!");

    // 消息码
    private String code;
    // 消息内容
    private String msg;

    private BusinessMsgEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
