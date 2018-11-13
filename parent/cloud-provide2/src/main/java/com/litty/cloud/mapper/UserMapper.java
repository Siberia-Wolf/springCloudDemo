package com.litty.cloud.mapper;

import com.litty.cloud.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {

}
