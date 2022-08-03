package src.uploadio;

import java.io.File;

/**
 * File类的使用
 */
public class FileDemo {
    /**
     * java.iO.File类表示文件或目录
     * File类只用于表示文件或目录的信息（名称，大小等），不能用于文件内容的访问。
     * 常用的API：
     * 1.创建File对象：File file=new File(String path);注意：File.seperater();获取系统分隔符，如：“\”.
     * 2.boolean file.exists();是否存在.
     * 3.file.mkdir();或者file.mkdirs();创建目录或多级目录。
     * 4.file.isDirectory()判断是否是目录
     * file.isFile()判断是否是文件。
     * 5.file.delete();删除文件或目录。
     * 6.file.createNewFile();创建新文件。
     * 7.file.getName()获取文件名称或目录绝对路径。
     * 8.file.getAbsolutePath()获取绝对路径。
     * 9.file.getParent();获取父级绝对路径。
     */
    /*java.iO.File类表示文件或目录
    File类只用于表示文件或目录的信息（名称，大小等），不能用于文件内容的访问。*/
    public static void main(String[] args) {
        File file=new File("D:\\111");//创建文件对象时指定目录需要用双斜杠，因为“\”是转义字符
        /*目录的中间的分隔符可以用双斜杠，也可以用反斜杠，也可以用File.separator设置分隔符*/
//        File file1=new File("d:"+File.separator);
//        System.out.println(file.exists());//exists()判断文件或文件夹是否存在
        if(!file.exists()){//如果文件不存在
            file.mkdir();//创建文件夹mkdir()，还有mkdirs()创建多级目录
        }else{
            file.delete();//删除文件或文件夹
        }
        //判断是否是一个目录isDirectory,如果是目录返回true，如果不是目录或者目录不存在返回false
        System.out.println(file.isDirectory());
        //判断是否是一个文件isFile
        System.out.println(file.isFile());

        File file2=new File("D:\\222","123.txt");
        //常用API：
        System.out.println(file);//打印的是file.toString()的内容
        System.out.println(file.getAbsolutePath());//获取绝对路径
        System.out.println(file.getName());//获取文件名称
        System.out.println(file2.getName());
        System.out.println(file.getParent());//获取父级绝对路径
        System.out.println(file2.getParentFile().getAbsolutePath());
    }
}