package com.lzq.redisv.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.redisv.domain.entity.RedisInfo;
import com.lzq.redisv.mapper.RedisInfoMapper;
import com.lzq.redisv.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RedisInfoServiceImpl extends ServiceImpl<RedisInfoMapper, RedisInfo> implements RedisInfoService {

    private Map<String, Jedis> jedisMap = new HashMap<>();

    private final ServerService serverService;
    private final ClientsService clientsService;
    private final MemoryService memoryService;
    private final PersistenceService persistenceService;
    private final StatsService statsService;
    private final ReplicationService replicationService;
    private final CpuService cpuService;
    private final CommandStatsService commandStatsService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(RedisInfo entity) {
        serverService.save(entity.getServer());
        clientsService.save(entity.getClients());
        memoryService.save(entity.getMemory());
        persistenceService.save(entity.getPersistence());
        statsService.save(entity.getStats());
        replicationService.save(entity.getReplication());
        cpuService.save(entity.getCpu());
        commandStatsService.saveBatch(entity.getCommandStats());
        return true;
    }

    @Override
    public RedisInfo getById(Serializable id) {
        Jedis jedis = new Jedis("192.168.137.131", 6379);
        String info = jedis.info();
        List<String> infoStrList = StrUtil.split(info, "\n");
        infoStrList.stream().forEach(System.out::println);

        String commandStats = jedis.info("commandstats");
//        System.out.println(commandStats);
        List<String> commandStatsStrList = StrUtil.split(commandStats, "\n");

        RedisInfo redisInfo = RedisInfo.convert(infoStrList);
        redisInfo.addCommandStats(commandStatsStrList);
//        System.out.println(redisInfo.toString());
        return redisInfo;
    }
}




