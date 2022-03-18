package jvm.c3_jmm;

import java.lang.instrument.Instrumentation;

/**
 * @create 2021-01-18
 * @4:53
 */
public class ObjectSizeAgent {
    private static Instrumentation inst;

    public static void premain(String agentArgs, Instrumentation _inst) {
        inst = _inst;
    }

    public static long sizeOf(Object o) {
        return inst.getObjectSize(o);
    }

}
