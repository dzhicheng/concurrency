package com.dongzhic.concurrency.example.immutable;

import com.dongzhic.annoations.NotThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author dongzhic
 * @date 2018.05.16
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private static final Integer a = 1;
    private static final String b = "2";
    private static final Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 1);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        //cannot assign a value to final variable ''
//        a = 3;
//        b = "4";
//        map = new HashMap<Integer, Integer>();

        map.put(1, 3);
        log.info("{}", map.get(1));
    }

    public void test (final int a) {
        //cannot assign a value to final variable ''
//        a = 6;
    }

}
