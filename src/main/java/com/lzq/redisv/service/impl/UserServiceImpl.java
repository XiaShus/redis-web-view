package com.lzq.redisv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.redisv.domain.entity.User;
import com.lzq.redisv.service.UserService;
import com.lzq.redisv.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{

}




