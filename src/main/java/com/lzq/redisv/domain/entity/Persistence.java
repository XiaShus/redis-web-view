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
 * @TableName persistence
 */
@TableName(value ="persistence")
@Data
public class Persistence implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer redisId;

    /**
     * 
     */
    private String loading;

    /**
     * 
     */
    private String asyncLoading;

    /**
     * 
     */
    private String currentCowPeak;

    /**
     * 
     */
    private Double currentCowSize;

    /**
     * 
     */
    private Double currentCowSizeAge;

    /**
     * 
     */
    private String currentForkPerc;

    /**
     * 
     */
    private String currentSaveKeysProcessed;

    /**
     * 
     */
    private String currentSaveKeysTotal;

    /**
     * 
     */
    private String rdbChangesSinceLastSave;

    /**
     * 
     */
    private String rdbBgsaveInProgress;

    /**
     * 
     */
    private Date rdbLastSaveTime;

    /**
     * 
     */
    private String rdbLastBgsaveStatus;

    /**
     * 
     */
    private Date rdbLastBgsaveTimeSec;

    /**
     * 
     */
    private Date rdbCurrentBgsaveTimeSec;

    /**
     * 
     */
    private Double rdbLastCowSize;

    /**
     * 
     */
    private String rdbLastLoadKeysExpired;

    /**
     * 
     */
    private String rdbLastLoadKeysLoaded;

    /**
     * 
     */
    private String aofEnabled;

    /**
     * 
     */
    private String aofRewriteInProgress;

    /**
     * 
     */
    private String aofRewriteScheduled;

    /**
     * 
     */
    private Date aofLastRewriteTimeSec;

    /**
     * 
     */
    private Date aofCurrentRewriteTimeSec;

    /**
     * 
     */
    private String aofLastBgrewriteStatus;

    /**
     * 
     */
    private String aofLastWriteStatus;

    /**
     * 
     */
    private Double aofLastCowSize;

    /**
     * 
     */
    private String moduleForkInProgress;

    /**
     * 
     */
    private Double moduleForkLastCowSize;

    /**
     * 
     */
    private String aofRewrites;

    /**
     * 
     */
    private String rdbSaves;

    /**
     * 
     */
    private Double aofCurrentSize;

    /**
     * 
     */
    private Double aofBaseSize;

    /**
     * 
     */
    private String aofPendingRewrite;

    /**
     * 
     */
    private Double aofBufferLength;

    /**
     * 
     */
    private Double aofRewriteBufferLength;

    /**
     * 
     */
    private String aofPendingBioFsync;

    /**
     * 
     */
    private String aofDelayedFsync;

    /**
     * 
     */
    private Date loadingStartTime;

    /**
     * 
     */
    private String loadingTotalBytes;

    /**
     * 
     */
    private String loadingRdbUsedMem;

    /**
     * 
     */
    private String loadingLoadedBytes;

    /**
     * 
     */
    private String loadingLoadedPerc;

    /**
     * 
     */
    private String loadingEtaSeconds;

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