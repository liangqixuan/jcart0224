package io.lqx.jcartstoreback.enumeration;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/3/6 13:30
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
public enum OrderStatus {
    ToProcess,//待处理
    Processing,//处理中
    ToShip,//代发货
    Shipped,//已发货
    ToReceive,//代签收
    Received,//已签收
    ToPay,//待支付
    Paid,//已支付
    Cancel,//取消
    Denied,//拒绝
    Completed,//完成
    ToComment,//待评价
    Commented//已评价
}
