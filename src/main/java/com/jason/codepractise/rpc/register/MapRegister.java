package com.jason.codepractise.rpc.register;

import com.jason.codepractise.rpc.framework.URL;

import java.util.*;

/**
 * author: zhangkai
 * date: 2019-08-31
 * description:
 */
public class MapRegister {
    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void register(String interfaceName, URL url) {
        List<URL> list = REGISTER.get(interfaceName);
        if (list == null || list.isEmpty()) {
            list = Arrays.asList(url);
        } else {
            list.add(url);
        }
        REGISTER.put(interfaceName, list);
    }

    public static URL random(String interfaceName) {
        List<URL> list = REGISTER.get(interfaceName);
        return list.get(new Random().nextInt());
    }

}
