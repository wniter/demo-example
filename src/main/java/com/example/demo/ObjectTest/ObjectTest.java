package com.example.demo.ObjectTest;

/**
 * @create 2021-12-29 21:49
 */
public class ObjectTest {
    public static void main(String[] args) {
        //getClass,toString,equals,hashCode,wait,notifyAll,clone,<init>,notify,finalize
        System.out.println(valueAndClass(new ObjectTest()));
    }
    public static String valueAndClass(Object o) {
        if (o != null) {
            return o + " (class: " + o.getClass().getSimpleName() + ")";
        }
        return "null";
    }

    @Override
    protected void finalize () throws Throwable {
        try {
            // 创建 RunoobTest 对象
            ObjectTest cal = new ObjectTest();

            // 输出当前时间
            System.out.println("" + System.currentTimeMillis());

            // finalize cal
            System.out.println("Finalizing...");
            cal.finalize();
            System.out.println("Finalized.");

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }


}
