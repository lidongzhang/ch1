package app.conf.ApiResponse;

public class ApiResponse extends Response {

    private String code;
    private ResponseData result;
    private String msg;

    public ApiResponse(){}

    public ApiResponse(String code){
        this.code = code;
    }

    public ApiResponse(String code, ResponseData result){
        this.code = code;
        this.result = result;
    }

    public ApiResponse(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static ApiResponse success(){
        return new ApiResponse(CODE_SUCCESS);
    }

    public static ApiResponse success(ResponseData result){
        return new ApiResponse(CODE_SUCCESS, result);
    }

    public static ApiResponse fail(String msg){
        return new ApiResponse(CODE_FAIL, msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseData getResult() {
        return result;
    }

    public void setResult(ResponseData result) {
        this.result = result;
    }
}