package com.dongzhic.concurrency.example.singleton;

import com.dongzhic.annoations.ThreadSafe;

/**
 * 单例模式：饿汉模式
 *  单例实例在类初始化时创建
 * @author dongzhic
 * @date 2018.05.15
 */
@ThreadSafe
public class SingletonExample2 {

    /**
     * 私有构造函数
     */
    private SingletonExample2() {}

    /**
     * 单例对象
     */
    private static SingletonExample2 instance = new SingletonExample2();

    /**
     * 静态的工厂方法
     * @return 单例对象
     */
    public static SingletonExample2 getInstance () {
        return instance;
    }
}
