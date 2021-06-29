package org.kevin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.kevin.model.Tags;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/6/30
 */
@Mapper
public interface TagsMapper {
    int insert(Tags record);

    Tags selectById(@Param("id") Integer id);

    List<Tags> findAll();

    int deleteById(@Param("id") Integer id);
}
