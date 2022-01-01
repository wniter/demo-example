package com.example.demo.ClassTest;

import com.example.demo.config.Person;

import java.lang.reflect.Field;

/**
 * @create 2021-12-31 1:08
 */
//java.lang.reflect.Field
public class FieldTest {
    //    :1：Class.getDeclaredField(String name);
    //
    //返回一个 Field 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明字段（包括私有成员）。
    //
    //2：Class.getDeclaredFields();
    //
    // 返回 Field 对象的一个数组，该数组包含此 Class 对象所表示的类或接口所声明的所有字段（包括私有成员）。
    //
    //3:Class.getField(String name);
    //
    //返回一个 Field 对象，它反映此 Class 对象所表示的类或接口的指定公共成员字段。
    //
    //4:Class.getFields();
    //
    //返回一个包含某些 Field 对象的数组，该数组包含此 Class 对象所表示的类或接口的所有可访问公共字段。
    public static void main(String[] args) throws Exception {
        //get,setAccessible,getName,set,getType,getModifiers,getAnnotation,getGenericType,isAnnotationPresent,
        //getDeclaringClass,isAccessible,getInt,setInt,getAnnotations,isSynthetic,setBoolean,getLong,getBoolean,

        Field.class.getField("test");
        //在Java反射中Field用于获取某个类的属性或该属性的属性值

        Person person = new Person();
        //通过Class.getDeclaredField(String name)获取类或接口的指定已声明字段。
        Field f1 = person.getClass().getDeclaredField("name");
        System.out.println("-----Class.getDeclaredField(String name)用法-------");
        System.out.println(f1);
        System.out.println("-----Class.getDeclaredFields()用法-------");
        //通过Class.getDeclaredFields()获取类或接口的指定已声明字段。
        Field[] f2 = person.getClass().getDeclaredFields();
        for (Field field : f2) {
            System.out.println(field);
        }
        System.out.println("-----Class.getField(String name)用法-------");
        //通过Class.getField(String name)返回一个类或接口的指定公共成员字段，私有成员报错。
        Field f3 = person.getClass().getField("name");
        System.out.println(f3);
        //如果获取age属性(私有成员) 则会报错
        //Field f3=person.getClass().getField("name");
        System.out.println("-----Class.getFields()用法-------");
        //通过Class.getField()，返回 Class 对象所表示的类或接口的所有可访问公共字段。
        Field[] f4 = person.getClass().getFields();
        for (Field fields : f4) {
            //因为只有name属性为共有，因此只能遍历出name属性
            System.out.println(fields);
        }
    }
}
