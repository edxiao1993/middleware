package org.kevin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.kevin.model.Post;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/6/30
 */
@Mapper
public interface PostMapper {
    int insert(Post record);

    Post selectById(@Param("id") Integer id);

    List<Post> findAll();

    int deleteById(@Param("id") Integer id);
}
