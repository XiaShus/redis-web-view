package com.lzq.redisv.domain.dto;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : LZQ
 * @create 2022/6/27 15:22
 */
@Data
public class RedisConnectDTO {

    private String name;
    private String host;
    private Integer port;
    private String auth;
}
