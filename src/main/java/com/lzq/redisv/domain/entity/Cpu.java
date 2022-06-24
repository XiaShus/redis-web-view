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
 * @TableName cpu
 */
@TableName(value ="cpu")
@Data
public class Cpu implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer redisId;

    /**
     * 
     */
    private String usedCpuSys;

    /**
     * 
     */
    private String usedCpuUser;

    /**
     * 
     */
    private String usedCpuSysChildren;

    /**
     * 
     */
    private String usedCpuUserChildren;

    /**
     * 
     */
    private String usedCpuSysMainThread;

    /**
     * 
     */
    private String usedCpuUserMainThread;

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