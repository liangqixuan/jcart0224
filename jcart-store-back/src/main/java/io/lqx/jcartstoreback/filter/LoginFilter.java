package io.lqx.jcartstoreback.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import io.lqx.jcartstoreback.contant.ClientExceptionConstant;
import io.lqx.jcartstoreback.exception.ClientException;
import io.lqx.jcartstoreback.util.JWTUtil;
import io.lqx.jcartstoreback.vo.CustomerLoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/2 9:40
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Order(2)
@Component
public class LoginFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JWTUtil jwtUtil;

    @Value("${jwt.exclude.apiUrls}")
    private Set<String> excludeLoginApiUrls;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        final String method = request.getMethod();
        if (method.equals("OPTIONS")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        final String requestURI = request.getRequestURI();

        if (excludeLoginApiUrls.contains(requestURI)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String token = request.getHeader("jcartToken");
//        if (token == null || token.isEmpty()){
//            token = request.getParameter("jcartToken");
//        }
        if (token == null || token.isEmpty()) {
            throw new ClientException(ClientExceptionConstant.TOKEN_NOT_EXIST_ERRCODE, ClientExceptionConstant.TOKEN_NOT_EXIST_ERRMSG);
        }

        logger.info("verify login with token: {}", token);

        CustomerLoginVO administratorLoginVO = null;
        try {
            administratorLoginVO = jwtUtil.verifyToken(token);
        }catch (JWTVerificationException ex){
            throw new ClientException(ClientExceptionConstant.TOKEN_INVALID_ERRCODE, ex.getMessage());
        }

        request.setAttribute("customerId", administratorLoginVO.getCustomerId());
        request.setAttribute("customerUsername", administratorLoginVO.getUsername());

        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }
}


