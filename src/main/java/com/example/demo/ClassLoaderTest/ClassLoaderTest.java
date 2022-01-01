package com.example.demo.ClassLoaderTest;

import jdk.nashorn.internal.runtime.Version;

import java.io.InputStream;

/**
 * @create 2022-01-01 2:39
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        //getResourceAsStream,loadClass,getResource,getResources,getSystemClassLoader,getParent,getSystemResourceAsStream,
        //getSystemResource,getSystemResources,findClass,defineClass,findResource,findResources,getPackage,
        //setPackageAssertionStatus,setDefaultAssertionStatus,getPackages,setClassAssertionStatus,clearAssertionStatus,
        //resolveClass,findLoadedClass,findLibrary,<init>,definePackage,getPlatformClassLoader,registerAsParallelCapable,
        ClassLoaderTest.class.getClassLoader();

        InputStream stream = ClassLoaderTest.class.getResourceAsStream("/SomeTextFile.txt");
        System.out.println(stream != null);
        stream = ClassLoaderTest.class.getClassLoader().getResourceAsStream("SomeTextFile.txt");
        System.out.println(stream != null);
    }
    private static Class<?> type(String className) throws ClassNotFoundException {
        return ClassLoaderTest.class.getClassLoader().loadClass(className);
    }

    private static boolean hasResource(String path) {
        try {
            return Version.class.getClassLoader().getResource(path) != null;
        } catch (Throwable t) {
            return false;
        }
    }
}
