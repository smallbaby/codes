package com.jason.codepractise.rpc.protocol.http;

import com.jason.codepractise.rpc.framework.Invocation;
import com.jason.codepractise.rpc.provider.LocalMap;
import org.omg.CORBA.INV_FLAG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;

/**
 * author: zhangkai
 * date: 2019-08-31
 * description:
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InputStream inputStream = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation)objectInputStream.readObject();

            Class classImpl = LocalMap.get(invocation.getMethodName());

            Method method = classImpl.getMethod(invocation.getInterfaceName(), invocation.getParamTypes());

            String result = (String)method.invoke(classImpl.newInstance(), invocation.getParams());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
