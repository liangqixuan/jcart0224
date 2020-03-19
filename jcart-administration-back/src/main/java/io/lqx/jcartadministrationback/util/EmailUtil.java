package io.lqx.jcartadministrationback.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/19 14:56
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Component
@SuppressWarnings("all")
public class EmailUtil {

    // 打印日志
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Async //异步请求注解，重新开启一个线程，速度优化比较快
    public void send(String fromEmail,
                     String toEmail,
                     String title,
                     String content){
        // 创建简单邮件信息
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
        logger.info("send email succeed");
    }

}
