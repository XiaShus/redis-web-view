package com.lzq.redisv.task;

import com.lzq.redisv.domain.entity.RedisInfo;
import com.lzq.redisv.service.RedisInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : LZQ
 * @create 2022/6/27 15:53
 */
@Slf4j
@Component
public class RedisStatus {

    @Autowired
    RedisInfoService redisInfoService;

    @Scheduled(cron = "0/1 * * * * ? ")
    public void uploadRedisStatus() throws InterruptedException {
        log.info("执行了uploadRedisStatus");
        redisInfoService.uploadRedisStatus();
    }
}
