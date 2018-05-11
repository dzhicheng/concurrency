package com.dongzhic.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @desc synchronized修饰静态方法和类
 *     子类继承，调用synchronized修饰方法，synchronized不生效
 * @author dongzhic
 * @date 2018.05.10
 */
@Slf4j
public class SynchronizedExample2 {

    /**
     * synchronized修饰类
     * @param j
     */
    public void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i ++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    /**
     * synchronized修饰静态方法
     */
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i ++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        final SynchronizedExample2 example1 = new SynchronizedExample2();
        final SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }



}
