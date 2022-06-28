package com.lzq.redisv.controller;

import com.lzq.redisv.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : LZQ
 * @create 2022/6/27 14:56
 */
@RestController
@RequestMapping("/vue-element-admin/user")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {

    @PostMapping("login")
    public R login(Map req) {
        return R.success("admin-token");
    }

    @GetMapping("info")
    public R info(Map req) {
        HashMap<Object, Object> one = new HashMap<>();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("roles", new String[]{"admin"});
        map.put("introduction", "I am a super administrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "Super Admin");
        one.put("admin-token", map);
        return R.success(map);
    }
}
