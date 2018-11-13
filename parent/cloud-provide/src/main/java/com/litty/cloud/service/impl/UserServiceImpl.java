package com.litty.cloud.service.impl;

import com.litty.cloud.entity.User;
import com.litty.cloud.mapper.UserMapper;
import com.litty.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service(value = "userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        if(user == null){
            log.info("根据id-->{} 查询结果为空",id);
            return null;
        }
        log.info("根据id-->{} 查询结果{}",id,user);
        return user;
    }

    @Override
    public List<User> findUserAll() {
        List<User> list = userMapper.selectAll();
        if(!CollectionUtils.isEmpty(list)) {
            log.info("查询总条数---{}",list.size());
            list.forEach( (u) -> {
                log.info("查询结果--{}",u);
            });
        }
        return list;

    }


}
