package com.lzq.redisv.controller;

import com.lzq.redisv.domain.dto.RedisConnectDTO;
import com.lzq.redisv.domain.entity.RedisInfo;
import com.lzq.redisv.service.RedisInfoService;
import com.lzq.redisv.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 缓存监控
 *
 * @author LZQ
 */
@RestController
@RequestMapping("/vue-element-admin/redis")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CacheController {

    private final RedisInfoService redisInfoService;

    @GetMapping("test2")
    public R<RedisInfo> getInfo2(String redisId) throws Exception {
        RedisInfo redisInfo = redisInfoService.getById(redisId);

        redisInfoService.save(redisInfo);
        return R.success(redisInfo);
    }

    @PostMapping("testConnect")
    public R testConnect(@RequestBody RedisConnectDTO req) throws Exception {
        boolean flag =  redisInfoService.testConnect(req);
        return R.success(flag);
    }
}
