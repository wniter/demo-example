package src.uploadio;

/**
 * * 1. “& 0xff”的解释：
 * * 0xFF表示的是16进制（十进制是255），表示为二进制就是“11111111”。
 * * 那么&符表示的是按位数进行与（同为1的时候返回1，否则返回0）
 *
 * * 2.字节byte与int类型转换：
 * * Integer.toHexString(b & 0xff)这里先把byte类型的b和0xff进行了运算，然后Integer.toHexString取得了十六进制字符串
 * * 可以看出b & 0xFF运算后得出的仍然是个int,那么为何要和 0xFF进行与运算呢?直接 Integer.toHexString(b);,将byte强转为int不行吗?答案是不行的.
 * * 其原因在于:1.byte的大小为8bits而int的大小为32bits；2.java的二进制采用的是补码形式
 * * Integer.toHexString的参数是int，如果不进行&0xff，那么当一个byte会转换成int时，由于int是32位，而byte只有8位这时会进行补位。。。。。。
 * * 所以，一个byte跟0xff相与会先将那个byte转化成整形运算，这样，结果中的高的24个比特就总会被清0，于是结果总是我们想要的。
 *
 * * 3.utf-8编码:中文占用3个字节，英文占用1个字节
 * * gbk编码:中文占用2个字节，英文占用1个字节
 * * Java采用双字节编码（就是Java中的一个字符占两个字节）是utf-16be编码。中文占用2个字节，英文占用2个字节
 * *
 * * 4.当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，也需要用这种编码方式，否则会出现乱码
 *
 * * 5.文本文件 就是字节序列。可以是任意编码的字节序列。
 * * 如果我们在中文机器上直接创建文本文件，那么该文件只认识ANSI编码（例如直接在电脑中创建文本文件）
 */
public class EncodeDemo {

    /**
     * 测试文件编码
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String s="好好学习ABC";
        byte[] bytes1=s.getBytes();//这是把字符串转换成字符数组，转换成的字节序列用的是项目默认的编码（这里为UTF-8）
        for (byte b : bytes1) {
            //把字节（转换成了int）以16进制的方式显示
            System.out.print(Integer.toHexString(b & 0xff)+" ");//& 0xff是为了把前面的24个0去掉只留下后八位
        }
        System.out.println();
        /*utf-8编码中中文占用3个字节，英文占用1个字节*/
        byte[] bytes2 = s.getBytes("utf-8");//这里会有异常展示，我们就throw这个异常
        for (byte b : bytes2) {
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }
        System.out.println();
        /*gbk编码中文占用2个字节，英文占用1个字节*/
        byte[] bytes3 = s.getBytes("gbk");//这里会有异常展示，我们就throw这个异常
        for (byte b : bytes3) {
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }

        System.out.println();
        /*utf-16be编码中文占用2个字节，英文占用2个字节*/
        byte[] bytes4 = s.getBytes("utf-16be");//这里会有异常展示，我们就throw这个异常
        for (byte b : bytes4) {
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }

        System.out.println();
        /*当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，也需要用这种编码方式，否则会出现乱码*/
        String str1=new String(bytes4);//这时会使用项目默认的编码来转换，可能出现乱码
        System.out.println(str1);
        //要使用字节序列的编码来进行转换
        String str2=new String(bytes4,"utf-16be");
        System.out.println(str2);
    }
}