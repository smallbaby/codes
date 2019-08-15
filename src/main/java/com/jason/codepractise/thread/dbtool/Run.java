package com.jason.codepractise.thread.dbtool;

class DbTool {
    volatile private boolean prevIsA = false;

    synchronized public void backupA() {
        try {
            while (prevIsA == true) {
                wait(); // 暂定
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("⭐️⭐️⭐️⭐️⭐️");
            }
            prevIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void backupB() {
        try {
            while (prevIsA == false) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("△△△△△");
            }
            prevIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BackA extends Thread {
    private DbTool dbTool;

    public BackA(DbTool dbTool) {
        this.dbTool = dbTool;
    }

    @Override
    public void run() {
        dbTool.backupA();
    }
}

class BackB extends Thread {
    private DbTool dbTool;

    public BackB(DbTool dbTool) {
        this.dbTool = dbTool;
    }

    @Override
    public void run() {
        dbTool.backupB();
    }
}


public class Run {
    public static void main(String[] args) {
        DbTool dbTool = new DbTool();
        for (int i = 0; i < 20; i++) {
            BackB output = new BackB(dbTool);
            output.start();
            BackA input = new BackA(dbTool);
            input.start();
        }
    }
}
