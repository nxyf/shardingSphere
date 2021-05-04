package com.nxyf.shardingsphere.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author nxyf
 * @Date 2021/5/4 20:38
 * @Version 1.0
 **/
@Data
@TableName("t_user")
public class User {

    private Long userId;

    private String username;

    private String ustatus;
}
