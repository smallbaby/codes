package com.jason.codepractise.rpc.provider;


import java.util.HashMap;
import java.util.Map;

/**
 * author: zhangkai
 * date: 2019-08-31
 * description:
 */
public class LocalMap {
    private static Map<String, Class> MAP = new HashMap<>();

    public static void put(String interfaceName, Class implClass) {
        MAP.put(interfaceName, implClass);
    }

    public static Class get(String interfaceName) {
        return MAP.get(interfaceName);
    }

}
