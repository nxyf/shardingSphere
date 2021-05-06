package com.nxyf.shardingsphere.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nxyf.shardingsphere.entity.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    public Course selectCourseByDictId(Long cid);
}
