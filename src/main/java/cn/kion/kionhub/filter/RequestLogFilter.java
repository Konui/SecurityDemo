package cn.kion.kionhub.filter;

import cn.kion.kionhub.security.CustomizeFilterInvocationSecurityMetadataSource;
import com.google.common.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 记录所有请求相关信息的过滤器
 *
 * @Author Kion
 * @Date 2020-08-22 19:26
 */
@Slf4j
public class RequestLogFilter implements Filter {
    /**
     * 记录所有请求的相关信息
     *
     * @Param   servletRequest
     * @Param   servletResponse
     * @Param   filterChain
     * @Return  void
     *
     * @Date    2020-08-22 19:36
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Long start=System.currentTimeMillis();
        StringBuilder req = new StringBuilder("");
        HttpServletRequest r = (HttpServletRequest) servletRequest;
        req.append("user_ip:");
        req.append(r.getRemoteAddr());
        req.append(",\treq_uri:");
        req.append(r.getRequestURI());
        req.append(",\treq_method:");
        req.append(r.getMethod());
        //入参
        log.info("Request params:{{}}",req);

        filterChain.doFilter(servletRequest,servletResponse);
        HttpServletResponse s = (HttpServletResponse) servletResponse;
        StringBuilder rsp = new StringBuilder("");
        rsp.append("rsp_code:");
        rsp.append(s.getStatus());
        rsp.append("\tspend_time:");
        rsp.append(System.currentTimeMillis()-start);
        rsp.append("\tpathPermissionDOList:");
        rsp.append(CustomizeFilterInvocationSecurityMetadataSource.n);
        //出参
        log.info("Response params:{{}}",rsp);
    }
}
