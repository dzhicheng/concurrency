package com.dongzhic.concurrency.example.count;

import com.dongzhic.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author dongzhi
 * @date 2018.05.11
 * @desc synchronized修饰方法
 */
@Slf4j
@ThreadSafe
public class CountExample3 {

    /**
     * 请求总数
     */
    private static int clientTotal = 5000;

    /**
     * 同时并发执行的线程数
     */
    private static int threadTotal = 200;

    /**
     * 计数
     */
    private static int count = 0;

    public static void main(String[] args) throws Exception {

        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //计数器闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i ++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("Exception:"+e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }

    private static synchronized void add() {
        count ++;
    }
}
