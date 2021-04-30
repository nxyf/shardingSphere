package com.nxyf.shardingsphere.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName Course
 * @Description TODO
 * @Author nxyf
 * @Date 2021/4/28 15:00
 * @Version 1.0
 **/
@Data
@ToString
public class Course {

    private Long cid;

    private String cname;

    private Long userId;

    private String cstatus;
}
