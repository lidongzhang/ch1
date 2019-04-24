package app.conf.ApiResponse;

public class ResponsePageData extends ResponseData {

    public ResponsePageData( Object data, Long count){
        PageData pd = new PageData();
        pd.setCount(count);
        pd.setData(data);
        setCode(CODE_SUCCESS);
        setData(pd);
    }

    public static ResponsePageData success(Object data, Long count){
        return new ResponsePageData(data, count);
    }
}




