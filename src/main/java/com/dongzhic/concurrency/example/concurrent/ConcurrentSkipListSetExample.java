package com.dongzhic.concurrency.example.concurrent;

import com.dongzhic.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * TreeSet  -> ConcurrentSkipListSet
 * @author dongzhic
 * @date 2018.06.07
 */
@Slf4j
@ThreadSafe
public class ConcurrentSkipListSetExample {

    /**
     * 请求总数
     */
    private static int clientTotal = 5000;

    /**
     * 同时并发执行的线程数
     */
    private static int threadTotal = 200;

    private static Set<Integer> set = new ConcurrentSkipListSet<Integer>();

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
        log.info("{}", set.size());
    }

    private static void update(int i) {
        set.add(i);
    }
}
