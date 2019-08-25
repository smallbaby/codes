package com.jason.codepractise.sourcestudy.jasonhashmap;

/**
 * author: zhangkai
 * date: 2019-08-19
 * description:
 */
public interface Map<K, V> {
    // 长度
    int size();

    //是否为空
    boolean isEmpty();

    // 根据key获取value
    V get(Object key);
    // 设置key，value
    V put(K key, V value);
}
