package cn.kion.kionhub.filter;

import cn.kion.kionhub.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
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
    AdminService adminService;
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
        Long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        Long current = System.currentTimeMillis();
        adminService.insertLogs(servletRequest,servletResponse,start,current);
    }
    public void setAdminService(AdminService adminService){
        this.adminService=adminService;
    }
}
