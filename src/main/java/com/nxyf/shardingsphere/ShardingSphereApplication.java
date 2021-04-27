package com.nxyf.shardingsphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 分库分表：将一个数据库分为多个数据库，将原先的表分布在不同的数据库，将一个表再分为多个表
 * 垂直拆分：
 *    分表：操作数据库中某张表，把这张表中的某些字段存到一张新表中，再把剩余的字段存到另一张新表里
 *    分库：
 * 水平拆分：
 *    分表：
 *    分库：
 */
@SpringBootApplication
public class ShardingSphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereApplication.class, args);
    }

}
