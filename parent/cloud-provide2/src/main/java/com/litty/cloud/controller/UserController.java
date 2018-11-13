package com.litty.cloud.controller;

import com.litty.cloud.entity.User;
import com.litty.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/user"})
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"get/{id}"})
    public User getById(@PathVariable(name = "id") String id){
        log.info("-------->从 cloud-provide2 服务中获取数据");
        User user = userService.findUserById(id);
        log.info("用户：{}",user);
        return user;
    }

    @RequestMapping(value = {"getAll"})
    public List<User> getAll(){
        log.info("-------->从 cloud-provide2 服务中获取数据");
        List<User> list = userService.findUserAll();
        log.info("总条数--->{}",list.size());
        list.forEach( (u) -> {
            log.info("用户：{}",u);
        });
        return list;
    }

}
