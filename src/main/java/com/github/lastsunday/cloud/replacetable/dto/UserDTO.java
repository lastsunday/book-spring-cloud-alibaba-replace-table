package com.github.lastsunday.cloud.replacetable.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private Long id;
    private Long tenantId;
    private String tenantName;
}
