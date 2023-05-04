package org.fuli.service;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{
    @Override
    public void show() {
        System.out.println("show方法执行");
    }
}
