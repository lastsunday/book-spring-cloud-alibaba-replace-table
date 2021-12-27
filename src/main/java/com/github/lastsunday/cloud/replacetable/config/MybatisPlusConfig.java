package com.github.lastsunday.cloud.replacetable.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.github.lastsunday.cloud.replacetable.dto.UserDTO;
import com.github.lastsunday.cloud.replacetable.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@MapperScan("com.github.lastsunday.cloud.replacetable.mapper")
public class MybatisPlusConfig {

    public final static String TABLE_NAME_ORDER = "order";

    @Resource
    private UserService userService;

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
        dynamicTableNameInnerInterceptor.setTableNameHandler(new TableNameHandler() {
            @Override
            public String dynamicTableName(String sql, String tableName) {
                if (TABLE_NAME_ORDER.equals(tableName)) {
                    UserDTO userDTO = userService.getCurrentUser();
                    return tableName + "_" + userDTO.getTenantId();
                } else {
                    return tableName;
                }
            }
        });
        mybatisPlusInterceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);
        return mybatisPlusInterceptor;
    }

}
