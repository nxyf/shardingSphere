package com.nxyf.shardingsphere;

import com.nxyf.shardingsphere.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingSphereApplicationTests {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    void contextLoads() {
    }

}
