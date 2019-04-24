package app.api.service.util;

public class Page {

        public static Integer getOffset(Integer pageSize, Integer page){
        return (page - 1) * pageSize;
    }

    public static Integer getRowidStart(Integer pageSize, Integer page){
        return (page - 1) * pageSize + 1;  //sqlserver的rowdid 从1开始
    }

    public static Integer getRowidEnd(Integer pageSize, Integer page){
        return page * pageSize ;
    }
}
