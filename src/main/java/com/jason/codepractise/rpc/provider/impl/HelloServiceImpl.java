package com.jason.codepractise.rpc.provider.impl;

import com.jason.codepractise.rpc.provider.api.HelloService;

/**
 * author: zhangkai
 * date: 2019-08-31
 * description:
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String username) {
        return "hello " + username;
    }
}
