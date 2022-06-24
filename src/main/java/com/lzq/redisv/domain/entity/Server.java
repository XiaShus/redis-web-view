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
 * @TableName server
 */
@TableName(value ="server")
@Data
public class Server implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer redisId;

    /**
     * 
     */
    private String redisVersion;

    /**
     * 
     */
    private String redisGitSha1;

    /**
     * 
     */
    private String redisGitDirty;

    /**
     * 
     */
    private Integer redisBuildId;

    /**
     * 
     */
    private String redisMode;

    /**
     * 
     */
    private String os;

    /**
     * 
     */
    private String archBits;

    /**
     * 
     */
    private String multiplexingApi;

    /**
     * 
     */
    private String atomicvarApi;

    /**
     * 
     */
    private String gccVersion;

    /**
     * 
     */
    private Integer processId;

    /**
     * 
     */
    private String processSupervised;

    /**
     * 
     */
    private Integer runId;

    /**
     * 
     */
    private String tcpPort;

    /**
     * 
     */
    private Date serverTimeUsec;

    /**
     * 
     */
    private Date uptimeInSeconds;

    /**
     * 
     */
    private Date uptimeInDays;

    /**
     * 
     */
    private String hz;

    /**
     * 
     */
    private String configuredHz;

    /**
     * 
     */
    private String lruClock;

    /**
     * 
     */
    private String executable;

    /**
     * 
     */
    private String configFile;

    /**
     * 
     */
    private String ioThreadsActive;

    /**
     * 
     */
    private String shutdownInMilliseconds;

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