package com.zhang.springboot.springbootjpa.util;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PracticeTest {
    public static void main(String[] args) {
        final DataPrint dataPrint = new DataPrint();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (dataPrint.letterFlag){
                    dataPrint.printLetter();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (dataPrint.numFlag){
                    dataPrint.printNum();
                }
            }
        }).start();
    }
    static class DataPrint {
        // 线程结束标记
        public boolean letterFlag = true;
        public boolean numFlag = true;
        // 数字初始值
        int num = 1;
        // 字母A-Z 对应 65-90
        int letter = 65;
        // 线程等待标记
        boolean flag = true;
        // java线程并发库中的锁，相当于(synchronized)
        Lock lock = new ReentrantLock();
        // 线程并发库中用于线程之间通讯的类，相当于wait(),notify()
        Condition condLetter = lock.newCondition();
        Condition condNum = lock.newCondition();

        public void printLetter() {
            if (letter > 90) {
                letterFlag = false;
                return;
            }
            lock.lock();
            try {
                if (flag) {
                    condLetter.await();
                }
                System.out.println(Thread.currentThread().getName() + ":" + (char) letter);
                letter++;
                Thread.sleep(100);
                flag = true;
                condNum.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        public void printNum() {
            if (num >= 52) {
                numFlag = false;
                return;
            }
            lock.lock();

            try {
                if (!flag) {
                    condNum.await();
                }
                System.out.println(Thread.currentThread().getName()+":"+num);
                num++;
                System.out.println(Thread.currentThread().getName()+":"+num);
                num++;
                Thread.sleep(100);
                flag = false;
                condLetter.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}
