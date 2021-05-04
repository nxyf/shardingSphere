package com.nxyf.shardingsphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 分库分表：将一个数据库分为多个数据库，将原先的表分布在不同的数据库，将一个表再分为多个表
 * 垂直拆分：
 *    分表：操作数据库中某张表，把这张表中的某些字段存到一张新表中，再把剩余的字段存到另一张新表里
 *    分库：把数据库按照业务划分，专库专表(商品库商品表、订单库订单表，不同的服务器)
 * 水平拆分：
 *    分表：在同一个数据库中创建多个结构相同的表，可以通过数据的id奇偶实现在不同表中存储
 *    分库：创建多个与原库结构(包含的表)相同的数据库，将数据存在不同的数据库(可以通过数据的id奇偶实现)
 *
 * 在数据库设计阶段就要考虑垂直拆分，当数据量上来后，先考虑缓存、索引等，最后再考虑水平拆分
 * 带来的问题：
 *    1.跨节点连接查询   多次查询数据库
 *    2.多数据源管理
 *
 * shardingJdbc:轻量级的Java框架，增强版的jdbc驱动  做的事情并不是分库分表，操作分库分表的后数据源
 *    主要功能：数据分片和读写分离
 *    主要目的：简化分库分表的数据操作
 *
 * 规则约定：
 *     数据库规则：user_id为偶数存到edu_db_1库，user_id为奇数存到edu_db_2
 *     表规则：cid为偶数的存在course_1表，cid为奇数的存到course_2表
 *
 * 公共表：存储固定数据的表，表数据很少发生变化，查询时经常进行关联；在每个数据库中创建出相同结构的公共表
 */
@SpringBootApplication
@MapperScan("com.nxyf.shardingsphere.mapper")
public class ShardingSphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereApplication.class, args);
    }

}
