package com.dongzhic.concurrency.example.singleton;

import com.dongzhic.annoations.NotRecommend;
import com.dongzhic.annoations.NotThreadSafe;

/**
 * 单例模式：懒汉模式
 *  单例实例在第一次使用时创建
 * @author dongzhic
 * @date 2018.05.15
 */
@NotThreadSafe
@NotRecommend
public class SingletonExample1 {

    /**
     * 私有构造函数
     */
    private SingletonExample1 () {}

    /**
     * 单例对象
     */
    private static SingletonExample1 instance = null;

    /**
     * 静态的工厂方法
     * @return 单例对象
     */
    public static SingletonExample1 getInstance () {
        if (instance == null) {
            new SingletonExample1();
        }
        return instance;
    }
}
