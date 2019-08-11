package com.jason.codepractise.thread.threadsafe;

class ALgoin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("a", "aa");
    }
}

class BLogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("b", "bb");
    }
}



public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    synchronized public static void doPost(String username, String password) {
    // public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username=" + usernameRef + " password=" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ALgoin a = new ALgoin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }

}





