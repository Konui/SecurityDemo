package cn.kion.kionhub.config;

import cn.kion.kionhub.filter.RequestLogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Kion
 * @Date 2020-08-27 09:53
 */
@Configuration
public class FilterOrderConfig {
    @Bean
    public FilterRegistrationBean<RequestLogFilter> RegistTest1(){
        //通过FilterRegistrationBean实例设置优先级可以生效
        //通过@WebFilter无效
        FilterRegistrationBean<RequestLogFilter> bean = new FilterRegistrationBean<RequestLogFilter>();
        bean.setFilter(new RequestLogFilter());//注册自定义过滤器
        bean.setName("RequestLogFilter");//过滤器名称
        bean.addUrlPatterns("/*");//过滤所有路径
        bean.setOrder(1);//优先级，最顶级
        return bean;
    }
}
