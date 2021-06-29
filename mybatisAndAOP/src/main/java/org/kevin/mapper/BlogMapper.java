package org.kevin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.kevin.model.Blog;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/6/30
 */
@Mapper
public interface BlogMapper {
    int insert(Blog record);

    Blog selectById(@Param("id") Integer id);

    List<Blog> selectAll();

    int deleteById(@Param("id") Integer id);
}
