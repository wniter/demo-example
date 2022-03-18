package annotaion;

import java.lang.annotation.*;

/**
 * @create 2022-03-10 22:48
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /**
     * 供应商编号
     */
    public int id() default -1;
    /**
     * 供应商名字
     */
    public String name() default  "";
    /**
     * 供应商地址
     */
    public String address() default "";
}
