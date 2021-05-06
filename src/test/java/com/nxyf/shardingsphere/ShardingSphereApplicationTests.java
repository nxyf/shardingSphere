package com.nxyf.shardingsphere;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nxyf.shardingsphere.entity.Course;
import com.nxyf.shardingsphere.entity.Udict;
import com.nxyf.shardingsphere.entity.User;
import com.nxyf.shardingsphere.mapper.CourseMapper;
import com.nxyf.shardingsphere.mapper.DictMapper;
import com.nxyf.shardingsphere.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShardingSphereApplicationTests {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DictMapper dictMapper;

    //==============公共表==============
    @Test
    void addDictDB() {
        Udict udict = new Udict();
        udict.setUstatus("1");
        udict.setValue("启用");
        dictMapper.insert(udict);
    }


    @Test
    void delDictDB() {
        QueryWrapper<Udict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_id", 596452048933748737L);
        dictMapper.delete(queryWrapper);
    }

    //==============垂直分库分表==============
    @Test
    void addUserDB() {
        User user = new User();
        user.setUsername("java");
        user.setUstatus("normal");
        userMapper.insert(user);

    }


    @Test
    void queryUserDB() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", 596444867685515265L);
        User user = userMapper.selectOne(queryWrapper);
        System.out.printf("=========="+user+"------------");
    }

    //==============水平分库分表==============
    @Test
    void addCourseDB() {
            Course course = new Course();
            course.setCname("java");
            course.setUserId(1010L);
            course.setCstatus("normal");
            courseMapper.insert(course);
    }


    @Test
    void queryCourseDB() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid", 594907205359108097L);
        queryWrapper.eq("user_id", 1010L);
        Course course = courseMapper.selectOne(queryWrapper);
        System.out.printf("=========="+course+"------------");
    }

    @Test
    void queryCourseByDictIdDB() {

        Course course = courseMapper.selectCourseByDictId(594907205359108097L);
        System.out.printf("=========="+course+"------------");
    }

    //==============水平分表==============
    @Test
    void addCourse() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setCname("java"+i);
            course.setUserId(1010L);
            course.setCstatus("normal");
            courseMapper.insert(course);
        }

    }

    @Test
    void queryCourse() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        /*queryWrapper.eq("cid", 594834418481233920L);
        Course course = courseMapper.selectOne(queryWrapper);*/
//        System.out.printf("=========="+course+"------------");
        List<Course> courses = courseMapper.selectList(queryWrapper);
        for (Course cours : courses) {
            System.out.printf("=========="+cours+"------------");
        }

    }

}
