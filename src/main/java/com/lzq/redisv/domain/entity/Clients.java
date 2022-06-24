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
 * @TableName clients
 */
@TableName(value ="clients")
@Data
public class Clients implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer redisId;

    /**
     * 
     */
    private String connectedClients;

    /**
     * 
     */
    private String clusterConnections;

    /**
     * 
     */
    private String maxclients;

    /**
     * 
     */
    private String clientRecentMaxInputBuffer;

    /**
     * 
     */
    private String clientRecentMaxOutputBuffer;

    /**
     * 
     */
    private String blockedClients;

    /**
     * 
     */
    private String trackingClients;

    /**
     * 
     */
    private Date clientsInTimeoutTable;

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