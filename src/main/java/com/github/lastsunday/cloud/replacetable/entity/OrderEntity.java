package com.github.lastsunday.cloud.replacetable.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@TableName("order")
public class OrderEntity implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private Long orderId;
    private String orderName;
}
