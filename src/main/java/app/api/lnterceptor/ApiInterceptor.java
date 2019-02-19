package app.api.lnterceptor;


import app.api.service.user.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ApiInterceptor implements HandlerInterceptor {

    private Environment env;
    private UserInterface userInterface;

    public ApiInterceptor(Environment env, UserInterface userInterface){
        this.env = env;
        this.userInterface = userInterface;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object arg2)
            throws Exception {
        String api_login_url = env.getProperty("app.api-login-url");
        String api_error_url = env.getProperty("app.api-error-url");
        String error_url = env.getProperty("app.error-url");
        System.out.println("this is preHandle :");
        System.out.println(request.getRequestURI());
        System.out.println("compare login:" + request.getRequestURI().compareTo("/api/user/login"));

        //登陆和错误也不检查身份
        if (request.getRequestURI().compareTo(api_login_url) == 0 ||
            request.getRequestURI().compareTo(api_error_url) == 0 ||
            request.getRequestURI().compareTo(error_url) == 0){
            return true;
        }


        String user_token = request.getHeader("user_token");
        if (user_token == null ||
            user_token.equals("") ||
            userInterface.checkToken(user_token) == false) {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(api_error_url);
            request.setAttribute("app-error-msg", "没有用户身份");
            requestDispatcher.forward(request, response);
            return  false;
        }

        return true;
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
