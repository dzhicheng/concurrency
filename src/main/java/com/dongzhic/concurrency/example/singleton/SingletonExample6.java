package com.dongzhic.concurrency.example.singleton;

import com.dongzhic.annoations.ThreadSafe;

/**
 * 单例模式：饿汉模式
 *  单例实例在类初始化时创建
 * @author dongzhic
 * @date 2018.05.15
 */
@ThreadSafe
public class SingletonExample6 {

    /**
     * 私有构造函数
     */
    private SingletonExample6() {}

    /**
     * 单例对象
     */
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    /**
     * 静态的工厂方法
     * @return 单例对象
     */
    public static SingletonExample6 getInstance () {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
