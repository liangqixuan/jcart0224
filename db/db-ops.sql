 DROP TABLE IF EXISTS `jcart_product_detail`;
CREATE TABLE `jcart_product_detail` (
    `product_id` int NOT NULL,
    `description` text not null,
    `other_pic_urls` varchar(2000),
    PRIMARY KEY (`product_id`)
  ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;