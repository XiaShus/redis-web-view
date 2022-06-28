package com.lzq.redisv.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.redisv.domain.dto.RedisConnectDTO;
import com.lzq.redisv.domain.entity.RedisInfo;
import com.lzq.redisv.domain.model.EchartsData;
import com.lzq.redisv.mapper.RedisInfoMapper;
import com.lzq.redisv.service.*;
import com.lzq.redisv.util.WebSocketUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
//        infoStrList.stream().forEach(System.out::println);

        String commandStats = jedis.info("commandstats");
//        System.out.println(commandStats);
        List<String> commandStatsStrList = StrUtil.split(commandStats, "\n");

        RedisInfo redisInfo = RedisInfo.convert(infoStrList);
        redisInfo.addCommandStats(commandStatsStrList);
//        System.out.println(redisInfo.toString());
        return redisInfo;
    }

    @Override
    public boolean testConnect(RedisConnectDTO req) {
        Jedis jedis = null;
        try {
            jedis = new Jedis(req.getHost(), req.getPort(), 10 * 1000);
            if (StrUtil.isNotEmpty(req.getAuth())) {
                jedis.auth(req.getAuth());
            }
        } catch (Exception e) {
            return false;
        } finally {
            jedis.close();
        }
        return true;
    }

    @Override
    public void uploadRedisStatus() {
        RedisInfo redisInfo = getById(1);
        List<EchartsData> list = redisInfo.getCommandStats().stream().map(e -> {
            return new EchartsData(e.getType(), Integer.parseInt(e.getCalls()));
        }).collect(Collectors.toList());
//        System.out.println(list.size());
        WebSocketUtil.sendMessageByRedisId("1", JSONUtil.toJsonStr(list));
    }


    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("192.168.137.131", 6379);
        int n = 100000;
        for (int i = 0; i < n; i++) {
//            String s = RandomUtil.randomString(10);
//            if (RandomUtil.randomBoolean()){
//                jedis.set(s, s);
//            }else{
//                String s1 = jedis.get(s);
//            }
            jedis.info();
            Thread.sleep(10);
        }
    }
}




