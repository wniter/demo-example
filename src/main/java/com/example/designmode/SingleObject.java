package com.example.designmode;

/**
 * 单例模式
 * @create 2022-02-13 19:52
 */

/**
 * 单例类只能有一个实例。
 *单例类必须自己创建自己的唯一实例。
 * 单例类必须给所有其他对象提供这一实例。
 */
public class SingleObject {

    //创建一个singleObject对象
    private static SingleObject instance = new SingleObject();
    //添加构造方法
    private SingleObject() {

    }
    //获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }
    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();

        //显示消息
        object.showMessage();

    }
}
/**
 * Java实例化的几种方式
 * （1）用new 语句创建对象，这是最常用的创建对象方法。
 *      new User();
 * （2）运用反射手段，调用java.lang.Class或者java.lang.reflect.Constructor类的newInstance()实例方法。
 *      Class c = Class.forName(subClassName);
 *      1.c.newInstance;
 *      2.Constructor conn = c.getConstructor(String.class);
 *       conn.newInstance("name");
 * （3）调用对象的clone()方法
 *      User user1 = new User("Test");
 *      User user2 = null;
 *      user2 = (User) user1.clone;
 * （4）运用反序列化手段，调用java.io.ObjectInputStream对象的readObject()方法。
 *  public class Test {
 *         //序列化对象到文件
 *         public static void serialize(String fileName){
 *             try
 *             {
 *                 //创建一个对象输出流，讲对象输出到文件
 *                 ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName));
 *
 *                 UserInfo user=new UserInfo("renyanwei","888888",20);
 *                 out.writeObject(user);  //序列化一个会员对象
 *
 *                 out.close();
 *             }
 *             catch (Exception x)
 *             {
 *                 System.out.println(x.toString());
 *             }
 *
 *         }
 *         //从文件反序列化到对象
 *         public static void deserialize(String fileName){
 *             try
 *             {
 *                 //创建一个对象输入流，从文件读取对象
 *                 ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName));
 *
 *                 //读取UserInfo对象并调用它的toString()方法
 *                 UserInfo user=(UserInfo)(in.readObject());
 *                 System.out.println(user.toString());
 *
 *                 in.close();
 *             }
 *             catch (Exception x)
 *             {
 *                 System.out.println(x.toString());
 *             }
 *
 *         }
 *
 *         public static void main(String[] args) {
 *
 *             serialize("D:\\test.txt");
 *             System.out.println("序列化完毕");
 *
 *             deserialize("D:\\test.txt");
 *             System.out.println("反序列化完毕");
 *         }
 */
