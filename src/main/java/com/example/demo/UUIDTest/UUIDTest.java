package com.example.demo.UUIDTest;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * @create 2022-01-01 13:25
 */
public class UUIDTest {
    public static void main(String[] args) {
        //randomUUID,toString,fromString,<init>,equals,getLeastSignificantBits,
        // getMostSignificantBits,hashCode,nameUUIDFromBytes,compareTo,version,timestamp,variant,init,makeUuid,clockSequence,node
        //静态工厂来检索类型4(伪随机生成的)UUID。
        UUID randomUUID = UUID.randomUUID();
        String fileName = UUID.randomUUID().toString();
        String secondName = String.valueOf(UUID.randomUUID().fromString("name"));

    }
}
