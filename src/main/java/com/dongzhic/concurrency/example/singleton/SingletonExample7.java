package com.dongzhic.concurrency.example.singleton;

import com.dongzhic.annoations.Recommend;
import com.dongzhic.annoations.ThreadSafe;

/**
 * 枚举模式：最安全，推荐使用
 * @author dongzhic
 * @date 2018.05.15
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    /**
     * 私有构造函数
     */
    private SingletonExample7() {}

    public SingletonExample7 getInstance () {
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        /**
         * JVM保证这个方法绝对只执行一次
         */
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton() {
            return singleton;
        }
    }


}
