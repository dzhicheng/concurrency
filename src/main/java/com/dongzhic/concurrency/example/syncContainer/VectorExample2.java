package com.dongzhic.concurrency.example.syncContainer;

import com.dongzhic.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

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
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) throws Exception {

        while (true) {
            for (int i=0;i<10;i++){
                vector.add(i);
            }

            Thread thread1 = new Thread(){
                public void run () {
                    for (int i=0;i<vector.size();i++){
                        vector.remove(i);
                    }
                }
            };
            Thread thread2 = new Thread(){
                public void run() {
                    for (int i=0;i<vector.size();i++){
                         vector.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();
        }

    }

}