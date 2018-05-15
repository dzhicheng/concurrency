package com.dongzhic.concurrency.example.singleton;

import com.dongzhic.annoations.NotRecommend;
import com.dongzhic.annoations.ThreadSafe;

/**
 * 单例模式：懒汉模式-双重同步锁代理模式
 *  单例实例在第一次使用时创建
 *  1、分配对象的内存空间 memory = allocate()
 *  2、初始化对象 ctorInstance()
 *  3、设置instance指向刚分配的内存 instance = memory
 *
 *  JVM和CPU优化，发生指令重排
 *  1、分配对象的内存空间 memory = allocate()
 *  2、设置instance指向刚分配的内存 instance = memory
 *  3、初始化对象 ctorInstance()
 *
 * @author dongzhic
 * @date 2018.05.15
 */
@ThreadSafe
@NotRecommend
public class SingletonExample5 {

    /**
     * 私有构造函数
     */
    private SingletonExample5() {}

    /**
     * 单例对象
     * volatile + 双重检测机制 -> 禁止指令重排
     */
    private volatile static SingletonExample5 instance = null;

    /**
     * 静态的工厂方法
     * @return 单例对象
     */
    public static SingletonExample5 getInstance () {
        //双重检测机制
        if (instance == null) {
            //同步锁
            synchronized (SingletonExample5.class) {
                if (instance == null ) {
                    new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
