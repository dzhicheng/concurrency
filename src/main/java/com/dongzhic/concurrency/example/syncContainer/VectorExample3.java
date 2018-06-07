package com.dongzhic.concurrency.example.syncContainer;

import com.dongzhic.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * ArrayList线程安全
 * @author dongzhic
 * @date 2018.05.24
 */
@Slf4j
@NotThreadSafe
public class VectorExample3 {

    /**
     * foreach循环
     */
    private static void test1 (Vector<Integer> v1) {
        for (Integer i : v1) {
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    /**
     * 迭代器,java.util.ConcurrentModificationException
     */
    private static void test2 (Vector<Integer> v1) {
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            v1.remove(iterator.next());
        }
    }

    /**
     * 普通for循环
     */
    private static void test3 (Vector<Integer> v1) {
        for (int i=0; i<v1.size(); i++) {
            if (i == 3) {
                v1.remove(i);
            }
        }
    }


    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<Integer>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        test1(vector);
    }

}
