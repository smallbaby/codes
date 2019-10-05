package com.jason.codepractise.pattern.factory.newfactory;

/**
 * author: zhangkai
 * date: 2019-09-30
 * description:
 */
public class AnimalFarmTest {
    public static void main(String[] args) throws Exception {
        Animal a;
        AnimalFarm af;
        af = (AnimalFarm)(AnimalFarmTest.getInstance());
        a = af.newAnimal();
        a.show();
    }

    public static Object getInstance() throws Exception {
        String cName="com.jason.codepractise.pattern.factory.newfactory.CattleFarm";
        System.out.println("新类名："+cName);
        Class<?> c=Class.forName(cName);
        return c.newInstance();
    }
}



interface Animal {
    void show();
}

class Horse implements Animal {
    @Override
    public void show() {
        System.out.println("动物：马");
    }
}

class Cattle implements Animal {
    @Override
    public void show() {
        System.out.println("动物：牛");
    }
}

interface AnimalFarm {
    Animal newAnimal();
}

class HouseFarm implements AnimalFarm {
    @Override
    public Animal newAnimal() {
        System.out.println("新马出生.");
        return new Horse();
    }
}

class CattleFarm implements AnimalFarm {
    @Override
    public Animal newAnimal() {
        System.out.println("新牛出生.");
        return new Cattle();
    }
}






