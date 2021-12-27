package com.github.lastsunday.cloud.replacetable.service;

import com.github.lastsunday.cloud.replacetable.dto.UserDTO;

public interface UserService {

    UserDTO getCurrentUser();

    void login(Long userId);
}
