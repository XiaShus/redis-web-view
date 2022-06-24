package com.lzq.redisv.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName stats
 */
@TableName(value ="stats")
@Data
public class Stats implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer redisId;

    /**
     * 
     */
    private String totalConnectionsReceived;

    /**
     * 
     */
    private String totalCommandsProcessed;

    /**
     * 
     */
    private String instantaneousOpsPerSec;

    /**
     * 
     */
    private String totalNetInputBytes;

    /**
     * 
     */
    private String totalNetOutputBytes;

    /**
     * 
     */
    private String totalNetReplInputBytes;

    /**
     * 
     */
    private String totalNetReplOutputBytes;

    /**
     * 
     */
    private String instantaneousInputKbps;

    /**
     * 
     */
    private String instantaneousOutputKbps;

    /**
     * 
     */
    private String instantaneousInputReplKbps;

    /**
     * 
     */
    private String instantaneousOutputReplKbps;

    /**
     * 
     */
    private String rejectedConnections;

    /**
     * 
     */
    private String syncFull;

    /**
     * 
     */
    private String syncPartialOk;

    /**
     * 
     */
    private String syncPartialErr;

    /**
     * 
     */
    private String expiredKeys;

    /**
     * 
     */
    private String expiredStalePerc;

    /**
     * 
     */
    private Date expiredTimeCapReachedCount;

    /**
     * 
     */
    private String expireCycleCpuMilliseconds;

    /**
     * 
     */
    private String evictedKeys;

    /**
     * 
     */
    private String evictedClients;

    /**
     * 
     */
    private Date totalEvictionExceededTime;

    /**
     * 
     */
    private Date currentEvictionExceededTime;

    /**
     * 
     */
    private String keyspaceHits;

    /**
     * 
     */
    private String keyspaceMisses;

    /**
     * 
     */
    private String pubsubChannels;

    /**
     * 
     */
    private String pubsubPatterns;

    /**
     * 
     */
    private String latestForkUsec;

    /**
     * 
     */
    private String totalForks;

    /**
     * 
     */
    private String migrateCachedSockets;

    /**
     * 
     */
    private String slaveExpiresTrackedKeys;

    /**
     * 
     */
    private String activeDefragHits;

    /**
     * 
     */
    private String activeDefragMisses;

    /**
     * 
     */
    private String activeDefragKeyHits;

    /**
     * 
     */
    private String activeDefragKeyMisses;

    /**
     * 
     */
    private Date totalActiveDefragTime;

    /**
     * 
     */
    private Date currentActiveDefragTime;

    /**
     * 
     */
    private String trackingTotalKeys;

    /**
     * 
     */
    private String trackingTotalItems;

    /**
     * 
     */
    private String trackingTotalPrefixes;

    /**
     * 
     */
    private String unexpectedErrorReplies;

    /**
     * 
     */
    private String totalErrorReplies;

    /**
     * 
     */
    private String dumpPayloadSanitizations;

    /**
     * 
     */
    private String totalReadsProcessed;

    /**
     * 
     */
    private String totalWritesProcessed;

    /**
     * 
     */
    private String ioThreadedReadsProcessed;

    /**
     * 
     */
    private String ioThreadedWritesProcessed;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}