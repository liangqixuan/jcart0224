package io.lqx.jcartstoreback.filter;

import io.lqx.jcartstoreback.contant.ClientExceptionConstant;
import io.lqx.jcartstoreback.exception.ClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/2 9:46
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Order(1)
@Component
public class StaticResourceFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${static.resource.extensions}")
    private Set<String> extensions;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        final String method = request.getMethod();
        final String requestURI = request.getRequestURI();
        logger.info("method request uri: {} {}", method, requestURI);

        final String[] strings = requestURI.split("\\.");
        String ext = strings[strings.length - 1];
        ext = ext.toLowerCase();
        if (extensions.contains(ext)){
            throw new ClientException(ClientExceptionConstant.NOT_SUPPORT_STATIC_RESOURCE_ERRCODE,ClientExceptionConstant.NOT_SUPPORT_STATIC_RESOURCE_ERRMSG);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
    }
}
