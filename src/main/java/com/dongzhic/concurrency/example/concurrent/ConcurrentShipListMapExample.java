package com.dongzhic.concurrency.example.concurrent;

import com.dongzhic.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

/**
 * TreeMap  -> ConcurrentSkipListMap
 * @author dongzhic
 * @date 2018.05.24
 */
@Slf4j
@ThreadSafe
public class ConcurrentShipListMapExample {

    /**
     * 请求总数
     */
    private static int clientTotal = 5000;

    /**
     * 同时并发执行的线程数
     */
    private static int threadTotal = 200;

    private static Map<Integer, Integer> map = new ConcurrentSkipListMap<Integer, Integer>();

    public static void main(String[] args) throws Exception {

        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //计数器闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i ++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("Exception:"+e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("{}", map.size());
    }

    private static void update(int i) {
        map.put(i, i);
    }
}
