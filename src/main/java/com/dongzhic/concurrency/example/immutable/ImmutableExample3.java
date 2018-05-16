package com.dongzhic.concurrency.example.immutable;

import com.dongzhic.annoations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
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
public class ImmutableExample3 {

    private final static ImmutableList list = ImmutableList.of(1,2,3);
    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap map1 = ImmutableMap.of(1,2,3,4);
    private final static ImmutableMap map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(3,4).put(5,6).build();

    public static void main(String[] args) {
        list.add(4);
        System.out.println(list.toString());

        System.out.println(set.toString());
        System.out.println(map1.toString());
        System.out.println(map2.toString());
    }
}
