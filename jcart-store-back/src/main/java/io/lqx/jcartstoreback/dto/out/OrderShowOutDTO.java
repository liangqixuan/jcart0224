package io.lqx.jcartstoreback.dto.out;

import io.lqx.jcartstoreback.vo.OrderProductVO;
import lombok.Data;

import java.util.List;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/25 17:11
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@Data
public class OrderShowOutDTO {
    private Long orderId;
    private Byte status;
    private Double totalPrice;
    private Integer rewordPoints;
    private Long createTimestamp;
    private Long updateTimestamp;
    private Short shipMethod;
    private String shipAddress;
    private Double shipPrice;
    private Short payMethod;
    private String invoiceAddress;
    private Double invoicePrice;
    private String comment;
    private List<OrderProductVO> orderProducts;
    private List<OrderHistoryListOutDTO> orderHistories;
}
