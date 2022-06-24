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
 * @TableName memory
 */
@TableName(value ="memory")
@Data
public class Memory implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer redisId;

    /**
     * 
     */
    private String usedMemory;

    /**
     * 
     */
    private String usedMemoryHuman;

    /**
     * 
     */
    private String usedMemoryRss;

    /**
     * 
     */
    private String usedMemoryRssHuman;

    /**
     * 
     */
    private String usedMemoryPeak;

    /**
     * 
     */
    private String usedMemoryPeakHuman;

    /**
     * 
     */
    private String usedMemoryPeakPerc;

    /**
     * 
     */
    private String usedMemoryOverhead;

    /**
     * 
     */
    private String usedMemoryStartup;

    /**
     * 
     */
    private String usedMemoryDataset;

    /**
     * 
     */
    private String usedMemoryDatasetPerc;

    /**
     * 
     */
    private String totalSystemMemory;

    /**
     * 
     */
    private String totalSystemMemoryHuman;

    /**
     * 
     */
    private String usedMemoryLua;

    /**
     * 
     */
    private String usedMemoryLuaHuman;

    /**
     * 
     */
    private String usedMemoryScripts;

    /**
     * 
     */
    private String usedMemoryScriptsHuman;

    /**
     * 
     */
    private String maxmemory;

    /**
     * 
     */
    private String maxmemoryHuman;

    /**
     * 
     */
    private String maxmemoryPolicy;

    /**
     * 
     */
    private String memFragmentationRatio;

    /**
     * 
     */
    private String memFragmentationBytes;

    /**
     * 
     */
    private String allocatorFragRatio;

    /**
     * 
     */
    private String allocatorFragBytes;

    /**
     * 
     */
    private String allocatorRssRatio;

    /**
     * 
     */
    private String allocatorRssBytes;

    /**
     * 
     */
    private String rssOverheadRatio;

    /**
     * 
     */
    private String rssOverheadBytes;

    /**
     * 
     */
    private String allocatorAllocated;

    /**
     * 
     */
    private String allocatorActive;

    /**
     * 
     */
    private String allocatorResident;

    /**
     * 
     */
    private String memNotCountedForEvict;

    /**
     * 
     */
    private String memClientsSlaves;

    /**
     * 
     */
    private String memClientsNormal;

    /**
     * 
     */
    private String memClusterLinks;

    /**
     * 
     */
    private String memAofBuffer;

    /**
     * 
     */
    private String memReplicationBacklog;

    /**
     * 
     */
    private String memTotalReplicationBuffers;

    /**
     * 
     */
    private String memAllocator;

    /**
     * 
     */
    private String activeDefragRunning;

    /**
     * 
     */
    private String lazyfreePendingObjects;

    /**
     * 
     */
    private String lazyfreedObjects;

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