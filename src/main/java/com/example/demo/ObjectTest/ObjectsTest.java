package com.example.demo.ObjectTest;

import java.util.Objects;

/**
 * @create 2022-01-01 13:04
 */
public class ObjectsTest {
    public static void main(String[] args) {
        //equals,requireNonNull,hash,hashCode,toString,nonNull,isNull,deepEquals,compare,requireNonNullElse,requireNonNullElseGet

        // These two have the same value
        new String("test").equals("test") ;// --> true

// ... but they are not the same object
//        (new String("test") == "test") // --> false

// ... neither are these
//        new String("test") == new String("test") // --> false

// ... but these are because literals are interned by
// the compiler and thus refer to the same object
//        "test" == "test" // --> true

// ... but you should really just call Objects.equals()
        Objects.equals("test", new String("test")); // --> true
        Objects.equals(null, "test"); // --> false
    }

}
