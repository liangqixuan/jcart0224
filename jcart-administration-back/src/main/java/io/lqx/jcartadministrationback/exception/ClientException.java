package io.lqx.jcartadministrationback.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletException;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/26 18:22
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientException extends ServletException {

    private String errCode;// 错误码

    public ClientException(String errCode, String errMsg){
        super(errMsg);
        this.errCode = errCode;
    }
}
