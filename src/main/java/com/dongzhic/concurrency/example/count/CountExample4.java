package com.dongzhic.concurrency.example.count;

import com.dongzhic.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author dongzhi
 * @date 2018.05.11
 * @desc volatile关键字：适合状态标记量
 *    1.对变量的写操作不依赖当前值
 *    2.该变量没有包含在具有其他变量不变的式子中
 */
@Slf4j
@NotThreadSafe
public class CountExample4 {

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
    private static volatile int count = 0;

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

    private static void add() {
        count ++;
        //1.取出内存中count值
        //2.count+1
        //3.count重新写回主存
    }
}
