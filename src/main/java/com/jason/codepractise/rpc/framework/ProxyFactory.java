package com.jason.codepractise.rpc.framework;

import com.jason.codepractise.rpc.protocol.http.HttpClient;
import com.jason.codepractise.rpc.provider.api.HelloService;
import com.jason.codepractise.rpc.register.MapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author: zhangkai
 * date: 2019-09-01
 * description:
 */
public class ProxyFactory {
    public static <T> T getProxy(final Class interfaceClass) {
        Object object = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HttpClient httpClient = new HttpClient();
                Invocation invocation = new Invocation(HelloService.class.getName(), method.getName(), method.getParameterTypes(), args);

                // 负载均衡

                URL url = MapRegister.random(interfaceClass.getName());
                String result = httpClient.send(url.getHostname(), url.getPort(), invocation);
                System.out.println(result);
                return result;
            }
        });
        return (T) object;
    }
}
