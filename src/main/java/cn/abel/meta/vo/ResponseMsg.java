package cn.abel.meta.vo;

import cn.hutool.core.util.StrUtil;
import lombok.Data;


/**
 * @author junzhang27
 */
@Data
public class ResponseMsg {
    private boolean flag;
    private int code;
    private String desc;
    private Object data;

    public ResponseMsg() {
        this.flag = true;
        this.code = ReturnCode.SUCCESS.getKey();
        this.desc = ReturnCode.SUCCESS.getValue();
    }


    public static ResponseMsg errResponse(String desc) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.flag = false;
        responseMsg.code = -1;
        responseMsg.setDesc(desc);
        return responseMsg;
    }

    public static ResponseMsg success(Object data) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.code = ReturnCode.SUCCESS.getKey();
        responseMsg.flag = true;
        responseMsg.data = data;
        return responseMsg;
    }

    public ResponseMsg(KeyValuePair keyValuePair) {
        this.flag = keyValuePair.getKey() == 0;
        this.code = keyValuePair.getKey();
        if (StrUtil.isEmpty(keyValuePair.getDescr())) {
            this.desc = keyValuePair.getValue();
        } else {
            this.desc = keyValuePair.getDescr();
        }
    }

    public static ResponseMsg of(KeyValuePair keyValuePair) {
        return of(keyValuePair.getKey() == 0, keyValuePair.getKey(),
                StrUtil.isEmpty(keyValuePair.getDescr()) ? keyValuePair.getValue() : keyValuePair.getDescr(), null);
    }

    public static ResponseMsg ok(Object data, String msg) {
        return of(true, ReturnCode.SUCCESS.getKey(), msg, data);
    }

    public static ResponseMsg ok(Object data) {
        return of(true, ReturnCode.SUCCESS.getKey(), ReturnCode.SUCCESS.getValue(), data);
    }

    public static ResponseMsg ok() {
        return of(true, ReturnCode.SUCCESS.getKey(), ReturnCode.SUCCESS.getValue(), null);
    }

    public static ResponseMsg of(boolean flag, int code, String desc, Object data) {
        return new ResponseMsg(flag, code, desc, data);
    }

    public static ResponseMsg error() {
        return of(false, -1, "操作失败", null);
    }

    public static ResponseMsg error(String msg) {
        return of(false, -1, msg, null);
    }

    public static ResponseMsg error(Object data, String msg) {
        return of(false, -1, msg, data);
    }

    /**
     * 构造方法私有， 不希望直接使用该构造方法
     *
     * @param flag
     * @param code
     * @param desc
     * @param data
     */
    private ResponseMsg(boolean flag, int code, String desc, Object data) {
        this.flag = flag;
        this.code = code;
        this.desc = desc;
        this.data = data;
    }
}
