package com.dongzhic;

import com.dongzhic.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dongzhic
 * @date 2018.05.18
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    /**
     * 接口请求前做处理,请求处理之前进行调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        return true;
    }

    /**
     * 当前请求进行处理之后(Controller 方法调用之后执行)
     *  但是它会在DispatcherServlet 进行视图返回渲染之前被调用;
     *  先声明的Interceptor 的postHandle 方法反而会后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 接口请求后做处理,将在整个请求结束之后，
     *  在DispatcherServlet 渲染了对应的视图之后执行
     *  主要作用是用于进行资源清理工作的。
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequestHolder.remove();
        log.info("afterCompletion");
        return;
    }

}
