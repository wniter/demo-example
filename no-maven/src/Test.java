import entity.Person;

/**
 * @create 2022-03-19 1:39
 */
public class Test {
    public static void main(String[] args) {
        PersonRelect();
    }
    public static  void PersonRelect() {
        Class<? extends Person> aClass = new Person().getClass();
        System.out.println(aClass);
    }
}
