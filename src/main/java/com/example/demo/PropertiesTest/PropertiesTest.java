package com.example.demo.PropertiesTest;

import sun.tools.jar.Main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @create 2021-12-31 1:02
 */
public class PropertiesTest {
    public static void main(String[] args) {
        //<init>,getProperty,load,setProperty,put,get,entrySet,putAll,containsKey,store,keySet,stringPropertyNames,
        //remove,propertyNames,size,isEmpty,keys,clear,clone,toString,loadFromXML,equals,contains,forEach,list,
        //storeToXML,hashCode,values,containsValue,getOrDefault,elements,putIfAbsent,save,dumpString,listToAppendable,
        //selectProperties,substitutePredefinedEntries,replaceAll,computeIfAbsent,merge,replace,enumerateStringProperties,toHex


    }

    //
    private static String versionString() {
        try {
            Properties prop = new Properties();
            InputStream in = Main.class.getResourceAsStream("/okcurl-version.properties");
            //加载一个InputStream
            prop.load(in);
            in.close();

            //java.util.Properties.getProperty(String key) 方法将搜索此属性列表中指定键的属性值。
            // 如果在属性列表中，默认属性列表及其默认值找到了键，然后检查递归。如果未找到该属性的方法返回null
            return prop.getProperty("version");
        } catch (IOException e) {
            throw new AssertionError("Could not load okcurl-version.properties.");
        }
    }

    public static Properties overWriteProperties(Properties bp, Properties ovp) {
        for (String propertyName : ovp.stringPropertyNames()) {
            //set方法
            bp.setProperty(propertyName, ovp.getProperty(propertyName));
        }
        return bp;
    }

    private void overlay(Properties to, Properties from) {
        // public Set<Map.Entry<K,V>> entrySet() {
        //        if (entrySet==null)
        //            entrySet = Collections.synchronizedSet(new EntrySet(), this);
        //        return entrySet;
        //    }
        for (Map.Entry<Object, Object> entry : from.entrySet()) {

            // put and get
            to.put(entry.getKey(), entry.getValue());
        }
    }
    private Set<String> stringPropertyNames(Properties properties) {
        //jdk9以下版本Properties#enumerateStringProperties方法存在性能问题，keys() + get(k) 重复迭代, jdk9之后改为entrySet遍历.
        Map<String, String> h = new HashMap<>();
        for (Map.Entry<Object, Object> e : properties.entrySet()) {
            Object k = e.getKey();
            Object v = e.getValue();
            if (k instanceof String && v instanceof String) {
                h.put((String) k, (String) v);
            }
        }
        return h.keySet();
    }

    private void dumpProps(Properties systemProperties) {
        for(Object k: systemProperties.keySet()) {
            String key = (String) k;
            System.out.println(key + ": " + systemProperties.getProperty(key));
        }
    }
    private static void writeYarnProperties(Properties properties, File propertiesFile) {
        try (final OutputStream out = new FileOutputStream(propertiesFile)) {

            properties.store(out, "Generated YARN properties file");
        } catch (IOException e) {
            throw new RuntimeException("Error writing the properties file", e);
        }
        propertiesFile.setReadable(true, false); // readable for all.
    }
    public static void store( Map<String, String> config, Writer writer ) throws IOException
    {
        Properties properties = new Properties();
        properties.putAll( config );
        properties.store( writer, null );
    }
//    public void setProperty(String key, String value) {
//        if (value == null) {
//            properties.remove(key);
//        } else {
//            properties.put(key, value);
//        }
//    }
}
