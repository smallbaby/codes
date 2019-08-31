package com.jason.codepractise.rpc.consumer;

import com.jason.codepractise.rpc.framework.Invocation;
import com.jason.codepractise.rpc.framework.ProxyFactory;
import com.jason.codepractise.rpc.protocol.http.HttpClient;
import com.jason.codepractise.rpc.provider.api.HelloService;

/**
 * author: zhangkai
 * date: 2019-09-01
 * description:
 */
public class Consumer {
    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);

        String res = helloService.sayHello("xxx");
        System.out.println(res);


    }
}
