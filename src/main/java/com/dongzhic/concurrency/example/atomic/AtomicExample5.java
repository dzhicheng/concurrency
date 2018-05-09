package com.dongzhic.concurrency.example.atomic;

import com.dongzhic.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.privilegedactions.NewInstance;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @date 2018.05.08
 * @author dongzhic
 * @desc java.util.concurrent.atomic.AtomicIntegerFieldUpdater学习
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    @Getter
    private volatile int count = 100;

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    public static void main(String[] args) {

        AtomicExample5 example5 = new AtomicExample5();

        if (updater.compareAndSet(example5, 100, 200)) {
            log.info("update success 1, {}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 300)) {
            log.info("update success 2, {}", example5.getCount());
        } else {
            log.info("update failed , {}", example5.getCount());
        }

    }
}
