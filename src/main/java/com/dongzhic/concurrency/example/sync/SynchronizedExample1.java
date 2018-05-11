package com.dongzhic.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @desc synchronized修饰代码块、方法
 *     子类继承，调用synchronized修饰方法，synchronized不生效
 * @author dongzhic
 * @date 2018.05.10
 */
@Slf4j
public class SynchronizedExample1 {

    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i ++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    public synchronized void test2() {
        for (int i = 0; i < 10; i ++) {
            log.info("test2 - {}", i);
        }
    }

    public static void main(String[] args) {
        final SynchronizedExample1 example1 = new SynchronizedExample1();
        final SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }



}
