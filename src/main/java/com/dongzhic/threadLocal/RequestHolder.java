package com.dongzhic.threadLocal;

/**
 * 存储绑定在线程上的信息
 * @author dongzhic
 * @date 2018.05.16
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
