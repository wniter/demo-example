package com.example.demo.StreamTest;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;

/**
 * @create 2021-12-31 1:00
 */
public class InputStreamTest {
    public static void main(String[] args) {
        //close,read,available,skip,reset,mark,markSupported,transferTo
//InputStream 和 OutputStream为各种输入输出字节流的基类，所有字节流都继承这两个基类。

//        InputStream in = new InputStream(read()) {
//
//        };
//        OutputStream out;
//        IOUtils.copy(in,out);
//        in.close();
//        out.close();
    }
    public void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);

        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
    public static void cpdir(File src, File dest) throws Exception {
        dest.mkdirs();
        File[] files = src.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            File destFile = new File(dest.getPath() + File.separatorChar
                    + file.getName());
            if (file.isDirectory()) {
                cpdir(file, destFile);
                continue;
            }
            try {
                InputStream in = new FileInputStream(file);
                OutputStream out = new FileOutputStream(destFile);
                IOUtils.copy(in, out);
                in.close();
                out.close();
            } catch (IOException ex) {
                throw new Exception("Could not copy file: " + file, ex);
            }
        }
    }

}
