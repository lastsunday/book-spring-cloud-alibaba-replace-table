package com.github.lastsunday.cloud.replacetable.bo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderBO implements Serializable {

    private Long id;
    private Long orderId;
    private String orderName;
}
