package com.jason.codepractise.rpc.provider;

import com.jason.codepractise.rpc.framework.URL;
import com.jason.codepractise.rpc.protocol.http.HttpServer;
import com.jason.codepractise.rpc.provider.api.HelloService;
import com.jason.codepractise.rpc.provider.impl.HelloServiceImpl;
import com.jason.codepractise.rpc.register.MapRegister;

/**
 * author: zhangkai
 * date: 2019-08-31
 * description:
 */
public class Provider {
    public static void main(String[] args) {

        // 注册服务
        URL url = new URL("localhost", 9090);
        MapRegister.register(HelloService.class.getName(), url);

        LocalMap.put(HelloService.class.getName(), HelloServiceImpl.class);


        // 暴露服务


        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 9090);


    }
}
