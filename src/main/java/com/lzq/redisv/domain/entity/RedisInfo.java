package com.lzq.redisv.domain.entity;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : LZQ
 * @create 2022/6/24 10:11
 */
@Data
public class RedisInfo {

    private Server server;
    private Clients clients;
    private Memory memory;
    private Persistence persistence;
    private Stats stats;
    private Replication replication;
    private Cpu cpu;

    private List<CommandStats> commandStats;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public static RedisInfo convert(List<String> infoStrList) {
        JSONObject jsonObject = new JSONObject(infoStrList.size());
        Date date = new Date();
        jsonObject.putOpt("redis_id", 1);
        jsonObject.putOpt("create_time", date);
        jsonObject.putOpt("update_time", date);

        RedisInfo redisInfo = new RedisInfo();
        for (String infoAttr : infoStrList) {
            if (infoAttr.startsWith("#")) {
                continue;
            }
            int index = infoAttr.indexOf(":");
            if (index == -1) {
                continue;
            }
            jsonObject.putOpt(infoAttr.substring(0, index), infoAttr.substring(index + 1, infoAttr.length() - 1));
        }
//        System.out.println(jsonObject.toStringPretty());

        redisInfo.setServer(jsonObject.toBean(Server.class));
        redisInfo.setClients(jsonObject.toBean(Clients.class));
        redisInfo.setMemory(jsonObject.toBean(Memory.class));
        redisInfo.setPersistence(jsonObject.toBean(Persistence.class));
        redisInfo.setStats(jsonObject.toBean(Stats.class));
        redisInfo.setReplication(jsonObject.toBean(Replication.class));
        redisInfo.setCpu(jsonObject.toBean(Cpu.class));
        return redisInfo;
    }

    public void addCommandStats(List<String> commandStatsStrList) {
        List<CommandStats> commandStats = new ArrayList<>(commandStatsStrList.size());
        for (String commandAttr : commandStatsStrList) {
            if (commandAttr.startsWith("#")) {
                continue;
            }
            int index = commandAttr.indexOf(":");
            if (index == -1) {
                continue;
            }
            String type = commandAttr.substring(commandAttr.indexOf("_") + 1, index);
            String[] split = commandAttr.substring(index + 1, commandAttr.length() - 1).split(",");
            JSONObject temp = new JSONObject(split.length);
            for (String attr : split) {
                int attrIndex = attr.indexOf("=");
                temp.putOpt(attr.substring(0, attrIndex), attr.substring(attrIndex + 1));
            }
            CommandStats commandBean = temp.toBean(CommandStats.class);
            commandBean.setType(type);
            commandBean.setRedisId(server.getRedisId());
            commandBean.setCreateTime(server.getCreateTime());
            commandBean.setUpdateTime(server.getUpdateTime());
            commandStats.add(commandBean);
        }
        this.setCommandStats(commandStats);
    }
}
