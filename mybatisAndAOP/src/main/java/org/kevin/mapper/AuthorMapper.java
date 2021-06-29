package org.kevin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.kevin.model.Author;

import java.util.List;

/**
 * @author Kevin.Z
 * @version 2021/6/30
 */
@Mapper
public interface AuthorMapper {
    int insert(Author record);

    Author selectById(@Param("id") Integer id);

    List<Author> findAll();

    int deleteById(@Param("id") Integer id);
}
