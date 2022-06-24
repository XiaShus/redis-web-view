package com.lzq.redisv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.redisv.domain.entity.CommandStats;
import com.lzq.redisv.service.CommandStatsService;
import com.lzq.redisv.mapper.CommandStatsMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CommandStatsServiceImpl extends ServiceImpl<CommandStatsMapper, CommandStats>
implements CommandStatsService{

}




