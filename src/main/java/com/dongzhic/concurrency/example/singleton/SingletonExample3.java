package com.dongzhic.concurrency.example.singleton;

import com.dongzhic.annoations.NotRecommend;
import com.dongzhic.annoations.ThreadSafe;

/**
 * 单例模式：懒汉模式
 *  单例实例在第一次使用时创建
 * @author dongzhic
 * @date 2018.05.15
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    /**
     * 私有构造函数
     */
    private SingletonExample3() {}

    /**
     * 单例对象
     */
    private static SingletonExample3 instance = null;

    /**
     * 静态的工厂方法
     * @return 单例对象
     */
    public static synchronized SingletonExample3 getInstance () {
        if (instance == null) {
            new SingletonExample3();
        }
        return instance;
    }
}
