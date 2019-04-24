package app.api.lnterceptor;

import app.api.service.sysUser.SysUserInterface;
import app.home.controller.AppProperties;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ApiInterceptor implements HandlerInterceptor {

    private SysUserInterface sysUserInterface;

    private AppProperties appProperties;

    public ApiInterceptor(AppProperties appProperties, SysUserInterface sysUserInterface){
        this.appProperties = appProperties;
        this.sysUserInterface = sysUserInterface;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object arg2)
            throws Exception {
        String api_login_url = appProperties.getApi_login_url();
        String api_error_url = appProperties.getApi_error_url();
        String error_url = appProperties.getError_url();
        String api_download_url = appProperties.getApi_download_url();
        String api_upload_url = appProperties.getApi_upload_url();

        //登陆和错误也不检查身份
        if (request.getRequestURI().compareTo(api_login_url) == 0 ||
            request.getRequestURI().compareTo(api_error_url) == 0 ||
            request.getRequestURI().compareTo(error_url) == 0){
            return true;
        }

        //download 不能设置header只能用post提交的参数
        if(request.getRequestURI().compareTo(api_download_url) == 0 ||
           request.getRequestURI().contains(api_download_url) ||
           request.getRequestURI().compareTo(api_upload_url) == 0 ||
           request.getRequestURI().contains(api_upload_url)
            ) {
            String user_token = request.getParameter("user_token");
            if(sysUserInterface.getUserIdByUserToken(user_token) == null){
                forward(request, response, api_error_url);
                return false;
            }else
                return true;
        }

        String userId = sysUserInterface.getUserId();
        if(userId == null){
            forward(request, response, api_error_url);
            return  false;
        }

        return true;
    }

    private  void forward(HttpServletRequest request, HttpServletResponse response, String url) throws Exception{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        request.setAttribute("app-error-msg", "没有用户身份");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void postHandle(HttpServletRequest arg0,
                           HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse reponse, Object arg2, Exception arg3)
            throws Exception {

    }

}
