package com.lzq.redisv.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName redis
 */
@TableName(value ="redis")
@Data
public class Redis implements Serializable {
    /**
     * redis id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer userId;

    /**
     * 名称
     */
    private String name;

    /**
     * ip
     */
    private String host;

    /**
     * 端口号
     */
    private Integer port;

    /**
     * 校验密码
     */
    private String auth;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}