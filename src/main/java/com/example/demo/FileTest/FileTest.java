package com.example.demo.FileTest;

/**
 * @create 2021-12-31 22:27
 */
public class FileTest {
    public static void main(String[] args) {
        //<init>,exists,getAbsolutePath,getName,isDirectory,mkdirs,delete,listFiles,getParentFile,getPath,isFile,
        // length,toURI,createTempFile,createNewFile,toPath,mkdir,lastModified,toString,getCanonicalPath,deleteOnExit,
        // canRead,list,getAbsoluteFile,getParent,renameTo,canWrite,equals,getCanonicalFile,isAbsolute,toURL,
        // setLastModified,setExecutable,isHidden,hashCode,canExecute,setWritable,setReadable,getTotalSpace,getUsableSpace,
        // getFreeSpace,compareTo,setReadOnly,listRoots,doAccess,realpath,filenamesToFiles,doChmod,getAbsoluteName,
        // setLastModifiedImpl,checkURI,fixSlashes,join,listImpl,mkdirErrno,isRoot,getPrefixLength,slashify,isInvalid
        //java.io.File类是文件或路径的抽象表达，它实现了Serializable和Comparable接口，所以支持File对象的持久化，以及文件之间的大小比较。

    }
}
//①public File(String pathname)
//以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果是相对路径，则默认相对于当前project。
//
//File file1 = new File("hello.txt"); //相对路径
//File file2 = new File("C:\\IDEA\\untitled\\file\\hi.txt"); //绝对路径
//②public File(String parent,String child)
//以parent为父路径，child为子路径创建File对象。
//
//File file3 = new File("C:\\IDEA\\untitled\\", "file");
//③public File(File parent,String child)
//根据一个父File对象和子文件路径创建File对象
//
//File file3 = new File("C:\\IDEA\\untitled\\", "file");
//File file4 = new File(file3, "hi.txt");
//
//
//常用方法
//①File类的获取功能
//public String getAbsolutePath()：获取绝对路径
//public String getPath()：获取路径
//public String getName()：获取名称
//public String getParent()：获取上层文件目录路径，若无，返回null
//public long length()：获取文件长度（即：字节数），不能获取目录的长度
//public long lastModified()：获取最后一次的修改时间，毫秒值
//public String[] list()：获取指定目录下的所有文件或者文件目录的名称数组
//public File[] listFiles()：获取指定目录下的所有文件或文件目录构成的数组
//
//import java.io.File;
//
///**
//* @Author: Yeman
//* @Date: 2021-09-24-21:50
//* @Description:
//*/
//public class FileTest {
//  public static void main(String[] args) {
//      File file1 = new File("hello.txt");
//      File file2 = new File("C:\\IDEA\\untitled\\file\\hi.txt");
//
//      System.out.println(file1.getAbsolutePath());
//      System.out.println(file1.getPath());
//      System.out.println(file1.getName());
//      System.out.println(file1.getParent());
//      System.out.println(file1.length());
//      System.out.println(file1.lastModified());
//
//      System.out.println(file2.getAbsolutePath());
//      System.out.println(file2.getPath());
//      System.out.println(file2.getName());
//      System.out.println(file2.getParent());
//      System.out.println(file2.length());
//      System.out.println(file2.lastModified());
//  }
//}
//②File类的重命名功能
//public boolean renameTo(File dest)：把文件重命名为指定的文件路径和文件名，相当于是把真实文件转移并且重命名了
//
//import java.io.File;
//
///**
//* @Author: Yeman
//* @Date: 2021-09-24-21:50
//* @Description:
//*/
//public class FileTest {
//  public static void main(String[] args) {
//      File file1 = new File("hello.txt"); //file1需要在硬盘中真实存在
//      File file2 = new File("C:\\IDEA\\hi.txt"); //在硬盘中不存在file2
//      boolean b = file1.renameTo(file2);
//      System.out.println(b);
//  }
//}
//③File类的判断功能
//硬盘中要真实存在才能做出真实判断
//public boolean isDirectory()：判断是否是文件目录
//public boolean isFile()：判断是否是文件
//public boolean exists()：判断是否存在
//public boolean canRead()：判断是否可读
//public boolean canWrite()：判断是否可写
//public boolean isHidden()：判断是否隐藏
//
//④File类的创建功能
//public boolean createNewFile()：创建文件，若文件存在，则不创建，返回false
//public boolean mkdir()：创建文件目录，如果此文件目录存在，就不创建了，如果此文件目录的上层目录不存在，也不创建
//public boolean mkdirs()：创建文件目录，如果上层文件目录不存在，一并创建
//
//⑤File类的删除功能
//public boolean delete()：删除文件或者文件夹
//删除注意事项：Java中的删除不走回收站。要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
//
//import java.io.File;
//import java.io.IOException;
//
///**
//* @Author: Yeman
//* @Date: 2021-09-24-21:50
//* @Description:
//*/
//public class FileTest {
//  public static void main(String[] args) throws IOException {
//      File file1 = new File("hello.txt");
//      if (!file1.exists()){
//      	//文件不存在，创建
//          file1.createNewFile();
//          System.out.println("创建成功");
//      }else {
//      	//文件存在，删除
//          file1.delete();
//          System.out.println("删除成功");
//      }
//  }
//}