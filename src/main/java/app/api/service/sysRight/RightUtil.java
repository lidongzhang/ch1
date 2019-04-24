package app.api.service.sysRight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RightUtil {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

        public Map<String, List<UrlMethodEntiry>> getUrlClassMethod(){
        Map<String, List<UrlMethodEntiry>> controllerClass = new HashMap<String, List<UrlMethodEntiry>>();
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();
            String className = method.getMethod().getDeclaringClass().getName();
            List<UrlMethodEntiry> list = getMapUrlList(controllerClass, className);
            String methodName = method.getMethod().getName();
            String url = "";
            PatternsRequestCondition p = info.getPatternsCondition();
            for (String s : p.getPatterns()) {
                url = s;
            }
            UrlMethodEntiry urlMethodEntiry = new UrlMethodEntiry();
            urlMethodEntiry.setClassName(className);
            urlMethodEntiry.setUrl(url);
            urlMethodEntiry.setMethodName(methodName);
            list.add(urlMethodEntiry);
        }
        return  controllerClass;
    }

    private List<UrlMethodEntiry> getMapUrlList(Map<String, List<UrlMethodEntiry>> m, String className){
        List<UrlMethodEntiry> list = m.get(className);
        if(list == null){
            list = new ArrayList<>();
            m.put(className, list);
        }
        return list;
    }


}
