package com.example.demo.ClassTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

/**
 * @create 2022-01-01 20:30
 */
//java.lang.reflect.Constructor
public class ConstructorTest {
    private Constructor _constructor;
    public static void main(String[] args) throws Exception {
        //newInstance,getParameterTypes,setAccessible,getDeclaringClass,getModifiers,getParameterAnnotations,
        // getGenericParameterTypes,isAccessible,getAnnotation,getName,isVarArgs,getExceptionTypes,getParameterCount,
        // isAnnotationPresent,toString,getParameters,getGenericExceptionTypes,getTypeParameters,getDeclaredAnnotations,
        // equals,toGenericString,isSynthetic,getAnnotations,hashCode,getAnnotationsByType,<init>,getSignature,
        // initGenericTypes,appendTypeName,getSignatureAttribute,internalNewInstance,appendArrayGenericType,
        // checkAccessible,checkAccessibleFast,appendGenericType,getAnnotatedParameterTypes,getAnnotatedReturnType
        //调用
        ConstructorTest.class.getConstructors();
        //和获取类的方法一样，在反射的包里，获取类的构造器也是有两个方法:
        //1. Class.getDeclaredConstructors(): 获取非public的构造器。
        //2. Class.getConstructors(): 获取public的构造器。


        Class<?> cArg = Class.forName(args[1]);

        Class<?> c = Class.forName(args[0]);
        Constructor[] allConstructors = c.getDeclaredConstructors();
        for (Constructor ctor : allConstructors) {
            Class<?>[] pType = ctor.getParameterTypes();
            for (int i = 0; i < pType.length; i++) {
                if (pType[i].equals(cArg)) {
                    String.format("%s%n", ctor.toGenericString());

                    Type[] gpType = ctor.getGenericParameterTypes();
                    for (int j = 0; j < gpType.length; j++) {
                        char ch = (pType[j].equals(cArg) ? '*' : ' ');
                        String.format("%7c%s[%d]: %s%n", ch,
                                "GenericParameterType", j, gpType[j]);
                    }
                    break;
                }

            }
        }

    }
    protected Object instantiate ()throws Exception {
        return _constructor.newInstance();
    }
}