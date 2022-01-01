package com.example.demo.AssertTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;
/**
 * @create 2022-01-01 12:33
 */
public class AssertTest {
    //assertEquals,assertTrue,assertNotNull,assertFalse,fail,assertNull,assertThat,assertArrayEquals,assertNotEquals,
    //assertSame,assertNotSame,failNotEquals,failNotNull,formatClassAndValue,doubleIsDifferent,internalArrayEquals,
//equalsRegardingNull,failSame,failNotSame,format,failEquals,isEquals,assertThrows,floatIsDifferent

    //	void assertEquals(boolean expected, boolean actual)
    //检查两个变量或者等式是否平衡
    //2	void assertTrue(boolean expected, boolean actual)
    //检查条件为真
    //3	void assertFalse(boolean condition)
    //检查条件为假
    //4	void assertNotNull(Object object)
    //检查对象不为空
    //5	void assertNull(Object object)
    //检查对象为空
    //6	void assertSame(boolean condition)
    //assertSame() 方法检查两个相关对象是否指向同一个对象
    //7	void assertNotSame(boolean condition)
    //assertNotSame() 方法检查两个相关对象是否不指向同一个对象
    //8	void assertArrayEquals(expectedArray, resultArray)
    //assertArrayEquals() 方法检查两个数组是否相等
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(AssertTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
    public void testAssertions() {
        //test data
        String str1 = new String ("abc");
        String str2 = new String ("abc");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";
        int val1 = 5;
        int val2 = 6;
        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray =  {"one", "two", "three"};

        //Check that two objects are equal
        assertEquals(str1, str2);

        //Check that a condition is true
        assertTrue (val1 < val2);

        //Check that a condition is false
        assertFalse(val1 > val2);

        //Check that an object isn't null
        assertNotNull(str1);

        //Check that an object is null
        assertNull(str3);

        //Check if two object references point to the same object
        assertSame(str4,str5);

        //Check if two object references not point to the same object
        assertNotSame(str1,str3);

        //Check whether two arrays are equal to each other.
        assertArrayEquals(expectedArray, resultArray);
    }
    public void testPrototypeListFactory() throws Exception {
//        List list = (List) this.beanFactory.getBean("pListFactory");
//        assertTrue(list instanceof LinkedList);
//        assertTrue(list.size() == 2);
//        assertEquals("bar", list.get(0));
//        assertEquals("jenny", list.get(1));
    }
}
