package com.dongzhic.concurrency.example.immutable;

import com.dongzhic.annoations.NotThreadSafe;
import com.dongzhic.annoations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @author dongzhic
 * @date 2018.05.16
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static final Integer a = 1;
    private static final String b = "2";
    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 1);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        //cannot assign a value to final variable ''
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

}
