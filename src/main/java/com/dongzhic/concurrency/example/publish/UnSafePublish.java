package com.dongzhic.concurrency.example.publish;

import com.dongzhic.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 发布对象：使一个对象能够被当前对象之外的代码所使用
 * @author dongzhic
 * @date 2018.05.14
 */
@Slf4j
@NotThreadSafe
public class UnSafePublish {

    private String[] states = {"a", "b", "c"};

    public String[] getStates () {
        return states;
    }

    public static void main(String[] args) {
        UnSafePublish unsafePublish = new UnSafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

    }

}
