package app.conf.ApiResponse;

public class ResponseData  extends Response {

    private String code;
    private Object data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResponseData() {}
    public ResponseData(String code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
}
    public ResponseData(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResponseData(String code, Object data){
        this.code = code;
        this.data = data;
    }

    public ResponseData(Object data){
        this.code = CODE_SUCCESS;
        this.data = data;
    }

    public static ResponseData success(Object data){

        return new ResponseData(CODE_SUCCESS, data);
    }

    public static ResponseData fail(String msg){

        return new ResponseData(CODE_FAIL, msg);
    }

    public static ResponseData failWidthData(String msg, Object data){
        return new ResponseData(CODE_FAIL, msg, data);
    }
}
