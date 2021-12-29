package com.example.demo.ClassTest;

import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.lang.Nullable;

/**
 * @create 2021-12-29 22:32
 */
public class ClassTest {
    public static void main(String[] args) {
        //getName,getSimpleName,getClassLoader,isAssignableFrom,forName,newInstance,getMethod,getResourceAsStream,
        // getSuperclass,getConstructor,cast,isInstance,getCanonicalName,getDeclaredField,isArray,getAnnotation,
        // getDeclaredFields,getResource,getDeclaredMethod,getMethods,getPackage,getComponentType,isPrimitive,
        // getDeclaredMethods,getInterfaces,isInterface,getDeclaredConstructor,getModifiers,getField,isAnnotationPresent,
        // toString,isEnum,getEnumConstants,getConstructors,asSubclass,getGenericSuperclass,getFields,getProtectionDomain,
        // getDeclaredConstructors,getGenericInterfaces,getTypeParameters,getAnnotations,getEnclosingClass,isAnnotation,
        // isAnonymousClass,getDeclaringClass,isMemberClass,getDeclaredClasses,getDeclaredAnnotations,isLocalClass,getTypeName,
        // getClasses,isSynthetic,getAnnotationsByType,getEnclosingMethod,getDeclaredAnnotation,getEnclosingConstructor,
        // getSigners,desiredAssertionStatus,getModule,toGenericString,getDeclaredAnnotationsByType,getAnnotatedInterfaces,
        // getAnnotatedSuperclass,getDeclaredAnnotations0,getDeclaredClasses0,getDeclaredMethods0,getAnnotations0,
        // isDeclaredAnnotationPresent,classForName,getDeclaredFields0,getName0,getClassCache,
        System.out.println(ClassTest.class.getName());
        System.out.println(ClassTest.class.getSimpleName());
        System.out.println(ClassTest.class.getClassLoader());
        try {
            Class<?> clazz = Class.forName(ClassTest.class.getName());
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    public static boolean isSupportedType(@Nullable Class<!--?--> clazz) {
//        return (clazz != null && ((HttpEntity.class.isAssignableFrom(clazz) &&
//                !RequestEntity.class.isAssignableFrom(clazz)) ||
//                HttpHeaders.class.isAssignableFrom(clazz)));
//    }
}
