# Administrator 用户管理表

| 字段               | 类型         | 约束           | 说明                 |
| :----------------- | :----------- | :------------- | :------------------- |
| administrator_id   | int          | 主键 自增      | Id                   |
| username           | varchar(25)  | 非空，唯一索引 | 用户名               |
| real_name          | varchar(25)  | 索引           | 真实姓名             |
| email              | varchar(100) | 索引           | 邮箱                 |
| encrypted_password | varchar(100) | 非空           | 加密密码             |
| status             | tinyint      | 非空，默认启用 | 状态（0禁用，1启用） |
| create_time        | datetime     | 非空           | 创建时间             |
| avatar_url         | varchar(100) |                | 头像地址             |

# Product 商品表

| 字段             | 类型         | 约束           | 说明                 |
| :--------------- | :----------- | :------------- | :------------------- |
| product_id       | int          | 主键 自增      | Id                   |
| product_abstract | varchar(25)  | 非空           | 摘要                 |
| product_code     | varchar(25)  | 索引           | 商品代号             |
| product_name     | varchar(100) | 索引           | 商品名称             |
| price            | double       | 非空           | 商品价格             |
| discount         | duble        |                | 商品打折             |
| sort_order       | int          | 非空           | 排序                 |
| main_pic_url     | varchar(100) | 非空，唯一索引 | 主图                 |
| stock_quantity   | int          | 非空           | 库存量               |
| rewordPoints     | int          | 非空           | 积分                 |
| status           | tinyint      | 非空，默认启用 | 状态（0禁用，1启用） |

# ProductDetail 商品详细副表

| 字段           | 类型         | 约束       | 说明     |
| :------------- | :----------- | :--------- | :------- |
| product_id     | int          | 主键，自增 | ID       |
| description    | varchar(100) | 非空       | 商品描述 |
| other_pic_urls | varchar(100) | 非空       | 其他图片 |

# OrderHistory 订单历史表

| 字段               | 类型         | 约束           | 说明                 |
| :----------------- | :----------- | :------------- | :------------------- |
| order_history_id   | int          | 主键，自增     | ID                   |
| order_id           | int          | 唯一索引       | ID                   |
| time               | datatime     | 非空           | 时间                 |
| comment            | varchar(50)  | 非空           | 备注                 |
| order_staus        | tinyint      | 非空，默认启用 | 状态（0禁用，1启用） |
| customer_nototfied | varchar(100) | 非空           | 通知用户             |

# Order 订单表

| 字段          | 类型         | 约束           | 说明                                                         |
| :------------ | :----------- | :------------- | :----------------------------------------------------------- |
| customer_id   | int          | 主键 自增      | Id                                                           |
| order_id      | varchar(50)  | 唯一索引       | 订单id                                                       |
| ship_method   | varchar(50)  | 非空           | 寄送方式                                                     |
| pay_menthod   | varchar(100) | 索引           | 支付方式                                                     |
| reword_points | int(11)      | 非空           | 积分                                                         |
| status        | tinyint      | 非空，默认启用 | 状态（0待处理，1处理中，2代发货，3已发货，4代签收，5已签收，6待支付，7已支付，8取消，9拒绝，10完成） |
| total_price   | double       | 非空           | 总金额                                                       |
| create_time   | datatime     | 非空           | 创建时间                                                     |
| update_time   | datetime     | 非空           | 修改时间                                                     |

# Return 退货表

| 字段          | 类型         | 约束           | 说明                   |
| :------------ | :----------- | :------------- | :--------------------- |
| return_id     | int          | 主键 自增      | Id                     |
| order_id      | int          | 唯一索引       | id                     |
| order_time    | datetime     | 非空           | 退货时间               |
| customer_name | varchar(100) | 索引           | 退货商品               |
| email         | varchar(50)  | 非空           | 邮箱                   |
| mobile        | varchar(50)  | 非空           | 手机号                 |
| product_code  | int          | 索引           | 商品代号               |
| product_name  | varchar(25)  | 非空           | 名称                   |
| quantity      | int          | 非空           | 退货数量               |
| reason        | varchar(100) | 非空           | 退货理论               |
| opened        | tinyint      | 非空，默认启用 | 开封（0未开封，1开封） |
| comment       | varchar(100) | 非空           | 备注                   |
| action        | varchar(100) | 非空           | 处理方式               |

# ReturnHistory 退货历史表

| 字段              | 类型         | 约束      | 说明     |
| :---------------- | :----------- | :-------- | :------- |
| return_id         | int          | 主键 自增 | Id       |
| return_history    | int          | 唯一索引  | id       |
| time              | datetime     | 非空      | 退货时间 |
| return_staus      | varchar(100) | 非空      |          |
| comment           | varchar(50)  | 非空      | 备注     |
| customer_notified | varchar(25)  | 非空      | 通知客户 |

# Customer 客户表

| 字段               | 类型         | 约束      | 说明       |
| :----------------- | :----------- | :-------- | :--------- |
| customer_id        | int          | 主键 自增 | Id         |
| usemame            | varchar(25)  | 索引      | 客户名称   |
| mobile             | varchar(25)  | 非空      | 客户手机号 |
| mobile_verified    | int(11)      | 索引      | 手机验证   |
| email              | varchar(25)  | 非空      | 邮箱       |
| email_verified     | varchar(25)  | 非空      | 邮箱验证   |
| real_name          | int          | 索引      | 客户姓名   |
| default_address_id | int(11)      | 唯一索引  | 默认地址id |
| encrypted_password | varchar(100) | 非空      | 加密密码   |
| news_subscribed    | int(1)       |           | 新闻订阅   |

# Address 地址表

| 字段            | 类型        | 约束      | 说明         |
| :-------------- | :---------- | :-------- | :----------- |
| address_id      | int         | 主键 自增 | Id           |
| customer_id     | int         | 索引      | 客户id       |
| receiver_names  | varchar(25) | 非空      | 收货人姓名   |
| receiver_mobile | varchar(25) | 非空      | 收货人手机号 |
| content         | varchar(25) | 非空      | 地址内容     |

# OrderDetail 订单详细副表

| 字段            | 类型         | 约束           | 说明     |
| :-------------- | :----------- | :------------- | :------- |
| order_id        | int          | 主键 自增      | Id       |
| ship_address    | varchar(100) | 非空           | 寄送地址 |
| invoice_address | varchar(25)  |                | 发票地址 |
| ship_price      | double       | 非空           | 邮费     |
| product_id      | int          | 非空，唯一索引 | Id       |
| product_code    | int          | 非空           | code     |
| product_name    | varchar(25)  | 非空           | 名称     |
| unit_price      | double       | 非空           | 单价     |
| quantity        | int(11)      | 非空           | 数量     |