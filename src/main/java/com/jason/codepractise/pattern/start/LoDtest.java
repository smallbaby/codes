package com.jason.codepractise.pattern.start;

/**
 * author: zhangkai
 * date: 2019-09-29
 * description:迪米特法则
 */
public class LoDtest {
    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.setMyStar(new Star("贝克汉姆"));
        agent.setMyFans(new Fans("粉丝小小小贝."));
        agent.setMyCompany(new Company("北京传媒."));
        agent.meeting();
        agent.business();
    }
}

// 经纪人
class Agent {
    private Star myStar;
    private Fans myFans;
    private Company myCompany;

    public Star getMyStar() {
        return myStar;
    }

    public void setMyStar(Star myStar) {
        this.myStar = myStar;
    }

    public Fans getMyFans() {
        return myFans;
    }

    public void setMyFans(Fans myFans) {
        this.myFans = myFans;
    }

    public Company getMyCompany() {
        return myCompany;
    }

    public void setMyCompany(Company myCompany) {
        this.myCompany = myCompany;
    }

    public void meeting() {
        System.out.println(myFans.getName() + "与明星" + myStar.getName() + "见面了.");
    }

    public void business() {
        System.out.println(myCompany.getName() + "与明星" + myStar.getName() + "洽谈业务.");
    }

}

// 明星
class Star {
    private String name;

    Star(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

//粉丝
class Fans {
    private String name;

    Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

//媒体公司
class Company {
    private String name;

    Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}







