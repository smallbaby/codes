package com.jason.codepractise.pattern.adapter.motor;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * author: zhangkai
 * date: 2019-10-05
 * description: /Users/zhangkai/workspace/project/java/codes/src/main/java/com/jason/codepractise/pattern/adapter/motor/config.xml
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("适配器模型测试....");
        Motor motor = (Motor) ReadXML.getObject();
        motor.drive();
    }
}

//目标：发动机
interface Motor {
    void drive();
}

//适配者1
class ElectricMotor {
    public void electricDrive() {
        System.out.println("电能发动机驱动汽车！！！");
    }
}

class OpticalMotor {
    public void opticalDrive() {
        System.out.println("光能发动机驱动汽车!!!");
    }
}

class ElectricAdapter implements Motor {
    private ElectricMotor electricMotor;
    public ElectricAdapter() {
        electricMotor = new ElectricMotor();
    }
    @Override
    public void drive() {
        electricMotor.electricDrive();
    }
}

class OpticalAdapter implements Motor {
    private OpticalMotor opticalMotor;
    public OpticalAdapter() {
        opticalMotor = new OpticalMotor();
    }
    @Override
    public void drive() {
        opticalMotor.opticalDrive();
    }
}

class ReadXML {
    public static Object getObject() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=dFactory.newDocumentBuilder();
            Document doc;
            doc=builder.parse(new File("/Users/zhangkai/workspace/project/java/codes/src/main/java/com/jason/codepractise/pattern/adapter/motor/config.xml"));
            NodeList nl=doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName="com.jason.codepractise.pattern.adapter.motor."+classNode.getNodeValue();
            Class<?> c=Class.forName(cName);
            Object obj=c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


