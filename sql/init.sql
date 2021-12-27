create database spring_cloud_alibaba_practice_replace_table;
use spring_cloud_alibaba_practice_replace_table;
CREATE TABLE order_1(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id BIGINT,
    order_name VARCHAR(255)
);
CREATE TABLE order_2(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id BIGINT,
    order_name VARCHAR(255)
);
INSERT INTO order_1(id,order_id,order_name) VALUES(1,10001,'user_1_order');
INSERT INTO order_2(id,order_id,order_name) VALUES(1,20001,'user_2_order');

