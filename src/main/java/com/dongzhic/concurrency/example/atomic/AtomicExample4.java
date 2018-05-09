package com.dongzhic.concurrency.example.atomic;

import com.dongzhic.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @date 2018.05.08
 * @author dongzhic
 * @desc java.util.concurrent.atomic.AtomicReference
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {

    private static AtomicReference<Integer> count = new AtomicReference<Integer>(0);

    public static void main(String[] args) {

        //count == 2
        count.compareAndSet(0, 2);
        //不执行
        count.compareAndSet(0, 1);
        //不执行
        count.compareAndSet(1, 3);
        //count == 4
        count.compareAndSet(2, 4);
        //不执行
        count.compareAndSet(3, 5);

        log.info("count:{}", count.get());

    }
}
