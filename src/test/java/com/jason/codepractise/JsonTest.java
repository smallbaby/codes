package com.jason.codepractise;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


public class JsonTest {

    @Test
    public void testMapJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "one");
        map.put("key2", "two");
        String mapJson = JSON.toJSONString(map);
        System.out.println(mapJson);
    }

    @Test
    public void testUserJson() {
        ParserConfig.getGlobalInstance().addAccept("com.autohome.data.bdp_autobi.zk.");
        User user = new User();
        user.setAge(12);
        user.setName("kaizh");
        System.out.println(user.getClass().getName());
        String serUser = JSON.toJSONString(user);
        System.out.println(serUser);
        String serUser1 = JSON.toJSONString(user, SerializerFeature.WriteClassName);
        System.out.println(serUser1);
        User u = (User)JSON.parse(serUser1);
        System.out.println(u);
        Object obj = JSON.parseObject(serUser1);
        System.out.println(obj.getClass().getName());
        User u1 = JSON.parseObject(serUser1, User.class);
        System.out.println(u1.getName());
    }
}
