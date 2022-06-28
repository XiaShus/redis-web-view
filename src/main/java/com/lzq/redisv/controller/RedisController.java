package com.lzq.redisv.controller;

import com.lzq.redisv.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : LZQ
 * @create 2022/6/28 9:54
 */
@RestController
@RequestMapping("/vue-element-admin/user")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RedisController {

    private final RedisService redisService;




}
