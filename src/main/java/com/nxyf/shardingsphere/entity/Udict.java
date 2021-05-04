package com.nxyf.shardingsphere.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName Udict
 * @Description TODO
 * @Author nxyf
 * @Date 2021/5/4 21:19
 * @Version 1.0
 **/
@Data
@TableName("t_udict")
public class Udict {

    private Long dictId;

    private String ustatus;

    private String value;
}
