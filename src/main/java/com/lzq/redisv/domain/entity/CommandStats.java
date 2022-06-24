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
 * @TableName command_stats
 */
@TableName(value ="command_stats")
@Data
public class CommandStats implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer redisId;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String calls;

    /**
     * 
     */
    private String usec;

    /**
     * 
     */
    private String usecPerCall;

    /**
     * 
     */
    private String rejectedCalls;

    /**
     * 
     */
    private String failedCalls;

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