package com.zhang.springboot.springbootjpa.util;

public class Test1 {
    static final Object object = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 18; i++) {
                    synchronized (object) {
                        if (i % 2 == 0) {
                            System.out.println(i);
                            object.notifyAll();
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println(i);
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            char[] c = {'A','B','C','D','E','F','G','H','I'};
            @Override
            public void run() {
                for (int i = 0; i <= 8; i++) {
                    synchronized (object){
                        System.out.println(c[i]);
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
