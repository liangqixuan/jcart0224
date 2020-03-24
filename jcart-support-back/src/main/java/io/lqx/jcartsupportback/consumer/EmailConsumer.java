package io.lqx.jcartsupportback.consumer;

import io.lqx.jcartsupportback.mq.EmailEvent;
import io.lqx.jcartsupportback.util.EmailUtil;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/20 15:05
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Component
//@RocketMQMessageListener(topic = "EmailConsumer",consumerGroup = "my-group1")
public class EmailConsumer implements RocketMQListener<EmailEvent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmailUtil emailUtil;

    // 邮件发送人
    @Value("${spring.mail.username}")
    private String formEmail;

    @Override
    public void onMessage(EmailEvent emailEvent) {
        logger.info("{}",emailEvent);
        emailUtil.send(formEmail,emailEvent.getToEmail(),emailEvent.getTitle(),emailEvent.getContent());
    }
}
