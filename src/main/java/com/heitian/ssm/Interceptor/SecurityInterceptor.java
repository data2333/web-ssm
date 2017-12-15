package com.heitian.ssm.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
public class SecurityInterceptor implements HandlerInterceptor {
    private List<String> excludedUrls;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("intercepter coming...");
        //不过滤的url处理
        String uri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (uri.endsWith(url)) {
                return true;
            }
        }
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            /**
             * 第一种方案，直接重定向到登录界面，这里需要注意重定向的路径，最好用绝对路径
             * 相对于第二种方案，第一种方案好处是减少异常输出，更直观易理解；缺点是硬编码，用绝对路径才能适配所有url
             */
            response.sendRedirect("/springmvc/user/logon");
            return false;

            /*第二种方案，直接抛出异常，在spring配置文件中捕获异常并跳转到对应的url
             * throw new AuthorizationException();
             *
            */
        }else {
            return true;
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
