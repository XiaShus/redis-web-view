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
 * @TableName replication
 */
@TableName(value ="replication")
@Data
public class Replication implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer redisId;

    /**
     * 
     */
    private String role;

    /**
     * 
     */
    private String masterFailoverState;

    /**
     * 
     */
    private String masterReplid;

    /**
     * 
     */
    private String masterReplid2;

    /**
     * 
     */
    private String masterReplOffset;

    /**
     * 
     */
    private String secondReplOffset;

    /**
     * 
     */
    private String replBacklogActive;

    /**
     * 
     */
    private Double replBacklogSize;

    /**
     * 
     */
    private String replBacklogFirstByteOffset;

    /**
     * 
     */
    private String replBacklogHistlen;

    /**
     * 
     */
    private String masterHost;

    /**
     * 
     */
    private String masterPort;

    /**
     * 
     */
    private String masterLinkStatus;

    /**
     * 
     */
    private String masterLastIoSecondsAgo;

    /**
     * 
     */
    private String masterSyncInProgress;

    /**
     * 
     */
    private String slaveReadReplOffset;

    /**
     * 
     */
    private String slaveReplOffset;

    /**
     * 
     */
    private String slavePriority;

    /**
     * 
     */
    private String slaveReadOnly;

    /**
     * 
     */
    private String replicaAnnounced;

    /**
     * 
     */
    private String masterSyncTotalBytes;

    /**
     * 
     */
    private String masterSyncReadBytes;

    /**
     * 
     */
    private String masterSyncLeftBytes;

    /**
     * 
     */
    private String masterSyncPerc;

    /**
     * 
     */
    private String masterSyncLastIoSecondsAgo;

    /**
     * 
     */
    private String masterLinkDownSinceSeconds;

    /**
     * 
     */
    private String connectedSlaves;

    /**
     * 
     */
    private String minSlavesGoodSlaves;

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