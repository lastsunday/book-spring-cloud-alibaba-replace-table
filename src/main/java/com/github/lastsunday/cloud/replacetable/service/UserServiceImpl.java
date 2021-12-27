package com.github.lastsunday.cloud.replacetable.service;

import com.github.lastsunday.cloud.replacetable.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Override
    public UserDTO getCurrentUser() {
        UserDTO userDTO = new UserDTO();
        Long currentId = threadLocal.get();
        userDTO.setId(currentId);
        userDTO.setTenantId(currentId);
        userDTO.setTenantName("Tenant"+currentId);
        return userDTO;
    }

    @Override
    public void login(Long userId) {
        threadLocal.set(userId);
    }


}
