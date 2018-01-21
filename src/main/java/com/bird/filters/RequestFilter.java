package com.bird.filters;

import com.bird.util.Token;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * author: 牛虻.
 * time:2018/1/19 0019
 * email:pettygadfly@gmail.com
 * doc:
 */
public class RequestFilter implements Filter {
    private static String[] passType = {"css", "js"};
    private Log log = LogFactory.getLog(RequestFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 不接收get请求
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = ((HttpServletRequest) servletRequest);
        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        String ip = servletRequest.getRemoteAddr();
        if (null == uri) {
            //无
        } else if (!IpFilter.isIllegal() || !IpFilter.checkIp(ip)) {
            //全员禁止登录，黑名单
        } else if ((uri.contains(".")
                || uri.equals("/")
                || uri.endsWith("/login")
                || uri.endsWith("/toLogin"))) {
            //域名过滤，非本网站域名直接pass
            //所有后缀直接放过，放过登录
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (uri.endsWith("/ssoLogin")) {
            //其他登录方式
        } else {
//            String token = (String) request.getAttribute("token");
//            if (null == token || !Token.authToken(token)) {
//                //针对表单请求非法不含
//                log.debug(uri + "+" + ip);
//                throw new RuntimeException("丢失的页面");
//            } else {
//                filterChain.doFilter(servletRequest, servletResponse);
//            }

            filterChain.doFilter(servletRequest, servletResponse);

        }
    }

    public void destroy() {

    }
}
