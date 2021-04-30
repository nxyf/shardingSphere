package com.nxyf.shardingsphere;

import com.nxyf.shardingsphere.entity.Course;
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
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setCname("java"+i);
            course.setUserId(1010L);
            course.setCstatus("noral");
            courseMapper.insert(course);
        }

    }

}
