package com.lzq.redisv.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : LZQ
 * @create 2022/6/27 16:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EchartsData {
    private String name;
    private Integer value;
}
