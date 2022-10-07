public class Main {

    public static Hello hello;

    public static void main(String[] args) {
//        Hello hello = new Hello() {
//            @Override
//            public String Hello() {
//                System.out.println(1);
//                return "00";
//            }
//        };
        hello.Hello();
    }
}

interface Hello {
    public String Hello();
}
//class Hello01 implements Hello {
//
//    @Override
//    public String Hello() {
//        System.out.println("01");
//        return "01";
//    }
//}
//class Hello02 implements Hello {
//
//    @Override
//    public String Hello() {
//        System.out.println("02");
//        return "02";
//    }
//}
