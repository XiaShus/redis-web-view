package com.lzq.redisv.controller;

import cn.hutool.core.util.StrUtil;
import com.lzq.redisv.domain.entity.RedisInfo;
import com.lzq.redisv.service.RedisInfoService;
import com.lzq.redisv.util.R;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServerCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

/**
 * 缓存监控
 *
 * @author LZQ
 */
@RestController
@RequestMapping("/monitor/cache")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CacheController {

    private final RedisTemplate<String, String> redisTemplate;

    private final RedisInfoService redisInfoService;

    @GetMapping("test1")
    public R<Map<String, Object>> getInfo() throws Exception {
        Properties info = (Properties) redisTemplate.execute((RedisCallback<Object>) RedisServerCommands::info);
        Properties commandStats = (Properties) redisTemplate.execute((RedisCallback<Object>) connection -> connection.info("commandstats"));
        Object dbSize = redisTemplate.execute((RedisCallback<Object>) RedisServerCommands::dbSize);

        Map<String, Object> result = new HashMap<>(3);
        result.put("info", info);
        result.put("dbSize", dbSize);

        List<Map<String, String>> pieList = new ArrayList<>();
        if (commandStats != null) {
            commandStats.stringPropertyNames().forEach(key -> {
                Map<String, String> data = new HashMap<>(2);
                String property = commandStats.getProperty(key);
                data.put("name", StringUtils.removeStart(key, "cmdstat_"));
                data.put("value", StringUtils.substringBetween(property, "calls=", ",usec"));
                pieList.add(data);
            });
        }
        result.put("commandStats", pieList);
        return R.success(result);
    }


    @GetMapping("test2")
    public R<RedisInfo> getInfo2(String redisId) throws Exception {
        RedisInfo redisInfo = redisInfoService.getById(redisId);

        redisInfoService.save(redisInfo);
        return R.success(redisInfo);
    }
}
