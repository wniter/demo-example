package com.example.demo.ClassTest;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/**
 * @create 2022-01-01 22:45
 */
public class MethodTest {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static void main(String[] args) throws Exception {
        //invoke,getName,getParameterTypes,getReturnType,setAccessible,getDeclaringClass,getAnnotation,getModifiers,
        // isAnnotationPresent,getGenericReturnType,getParameterAnnotations,getGenericParameterTypes,isAccessible,equals,
        // getAnnotations,toString,getExceptionTypes,getParameterCount,isBridge,isSynthetic,getParameters,hashCode,
        // toGenericString,isVarArgs,getDeclaredAnnotations,getDefaultValue,getTypeParameters,getGenericExceptionTypes,
        // isDefault,getAnnotationsByType,getDeclaredAnnotation,getAnnotatedReturnType,<init>,getDeclaredAnnotationsByType,

        //一个java.lang.reflect.Method对象提供关于类或者接口上单个方法的信息访问，所反射的方法可以是类方法或实例方法（包括抽象方法）；
        // 一个Method方法匹配实际参数时允许加宽转换，但是如果调用实际参数时变窄转换将会抛出IllegalArgumentException异常；

        Class<?> clazz = MethodTest.class;
        /**
         * 返回Method数组对象，对应Class对象的所有的公共方法，
         * 包括当前类、继承的父类、实现的接口声明的所有方法；
         *
         * 返回的数组中的元素没有排序，没有任何特定的顺序；
         *
         * 如果当前的Class对象代表的类、接口或者原始数据类型、void类型没有public类型的方法，
         * 将会返回一个长度为0的数组；
         */
        Method[] methods = clazz.getMethods();
        for(Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("-----------getDeclaredMethods-----------------------------");
        /**
         * 返回Method数组对象，对应Class对象的所有的public、protected、default、private方法，
         * 但是不包括继承的父类、实现的接口声明的所有方法；
         *
         * 返回的数组中的元素没有排序，没有任何特定的顺序；
         *
         * 如果当前的Class对象代表的类、接口或者原始数据类型、void类型没有public类型的方法，
         * 将会返回一个长度为0的数组；
         */
        Method[] methods1 = clazz.getDeclaredMethods();
        for(Method method1 : methods1) {
            System.out.println(method1.getName());
        }
        System.out.println("----------getMethod------------------------------");
        /**
         * 返回类、接口中声明的Method对象，若果同一个类、接口中声明了一个以上的具有相同
         * 参数类型的方法，并且其中一个方法具有比其它任何类型更具体的返回类型，则返回该
         * 方法；否则，任意选择一个方法返回；
         *
         * 如果在类、接口中没有搜索到对应的方法，则向它的父类、父接口去搜索，搜索逻辑如上；
         */
        Method method2 = clazz.getMethod("setAge", new Class[] {int.class});
        System.out.println(method2.getName());

        System.out.println("--------------getDeclaredMethod--------------------------");
        /**
         * 返回在指定Class对象或者接口中声明的Method对象；如果同一个类中声明了一个以上的具有相同
         * 参数类型的方法，并且其中一个方法具有比其它任何类型更具体的返回类型，则返回该方法；否则，
         * 任意选择一个方法返回；
         *
         */
        Method method3 = clazz.getDeclaredMethod("setAge", new Class[] {int.class});
        System.out.println(method3.getName());
    }

//    //获取Method对象
//    Class<?> clazz = MethodTest.class;
//    Method method = clazz.getDeclaredMethod("setAge", new Class[] {int.class});
//    //返回由Method对象表示的方法名称，以字符串形式返回。
//    String methodName = method.getName();
//    /**
//     * 如果flag设置为true,将会抑制安全检查器；如果为false，安全检查器将会校验访问的安全性；
//     * 也就是控制通过Method对象是否可以访问类、接口中私有的成员变量
//     */
//    method.setAccessible(true);
//    /**
//     * 返回一个此对象表示的方法的返回类型的Class对象
//     * 返回：此对象表示的方法的返回类型
//     */
//    Class<?> returnType = method.getReturnType();
//    /**
//     * 返回当前Method对象运行时的class对象，返回的class对象将会被Method方法对象锁定（synchronized)
//     *
//     * return java.lang.reflect.Method
//     */
//    Class<?> cla = method.getClass();
//    /**
//     * 返回声明当前类或接口对应方法所代表的的Class实例对象；
//     * return reflect.MethodTest
//     */
//    Class<?> claz = method.getDeclaringClass();
//    /**
//     * 返回方法对象声明的类型变量数组GenericDeclaration，数组的顺序按照声明的顺序返回；
//     * 如果没有声明类型变量将会返回数组长度为0的TypeVariable数组；
//     */
//    TypeVariable<Method>[] variable = method.getTypeParameters();
//    MethodTest obj = new MethodTest();
//    /**
//     * 调用由这个方法对象表示的基础方法，具有指定参数的指定对象；单个参数会自动的解包以匹配原始
//     * 类型参数，并且原始和引用类型参数都在必要是服从方法调用的类型转换；
//     *
//     * 如果基础方法是静态的，则忽略指定的参数，他可能为null;
//     *
//     * 如果基础方法所需的形式参数数量为0，则提供的参数数组可以为长度为0的数组或者null;
//     *
//     * 如果基础方法是实例方法，则使用Java语言规范（第二版第152.4.4节）中所记录的动态方法查找来调用；
//     * 特别是，将基于目标对象的运行时类型重写。
//     *
//     * 如果基础方法是静态的，则声明该方法的类如果尚未初始化则初始化。
//     *
//     * 如果该方法正常完成，返回的值将返回给调用方的调用方；如果该值具有一个原始类型，
//     * 则它首先被适当地包裹在一个对象中。但是，如果值具有原始类型数组的类型，则数组中
//     * 的元素是包在对象中的<i>不</i>；换句话说，返回一个原始类型数组。如果基础方法返回类型无效，
//     * 则调用返回null。
//     *
//     * @param obj 调用基础方法的对象；
//     * @param args方法调用中使用的参数；
//     * @return 将该对象表示的方法使用给定参数调用的结果；
//     *
//     * @exception IllegalAccessException、IllegalArgumentException、InvocationTargetException
//     * 、NullPointerException、ExceptionInInitializerError
//     */
//    Object result = method.invoke(obj, 1);
//    /**
//     * 如果该方法被声明为可以接受可变长的参数，则返回true,否则返回false;
//     */
//    boolean varArgs = method.isVarArgs();
//    /**
//     * 如果该方法是复合方法，则返回true,否则返回false;
//     */
//    boolean synthetic = method.isSynthetic();
//    /**
//     * 判断对象表示的方法是否可以访问，如果可以返回true,否则返回false;
//     */
//    boolean accessible = method.isAccessible();
//    /**
//     * 如果此方法是一个桥方法，则返回true,否则返回false;
//     */
//    boolean bridge = method.isBridge();
//    /**
//     * 返回由该方法对象表示的方法的java语言修饰符；作为整数，应该使用Modifier
//     * 类来对其进行解码
//     */
//    int code = method.getModifiers();
//    /**
//     * 返回一个类对象数组，该数组表示由该基础方法引发的异常类型
//     */
//    Class<?>[] eclassz = method.getExceptionTypes();
}
