package com.github.lzy.play.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-22
 */
@Configuration
@MapperScan("com.github.lzy.play.mapper")
public class MyBatisConfig {
}
