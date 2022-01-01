package com.example.demo.StreamTest;

import java.io.*;

/**
 * @create 2021-12-31 1:07
 */
public class OutputStreamTest {
    private static String fileName;
    public static void main(String[] args) {
        //write,close,flush,checkError,<init>

//InputStream 和 OutputStream为各种输入输出字节流的基类，所有字节流都继承这两个基类。
    }
    /*
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
    public static void readFileByBytes(String inFile, String outFile) {
        File file = new File(fileName);
        InputStream in = null;
        OutputStream out = null;
        try {
            byte[] tempbytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(inFile);
            out = new FileOutputStream(outFile);
            while ((byteread = in.read(tempbytes)) != -1) {
                out.write(tempbytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
                try {
                    out.close();
                } catch (IOException e1) {
                }
            }
        }
    }

}
