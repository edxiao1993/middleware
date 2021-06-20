package org.kevin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kevin.model.BlogUser;

@Mapper
public interface BlogUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    BlogUser selectByPrimaryKey(String id);

    BlogUser selectByUsername(String username);

    int updateByPrimaryKeySelective(BlogUser record);

    int updateByPrimaryKey(BlogUser record);
}