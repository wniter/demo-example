package src.uploadio;

import java.io.File;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.Socket;
public class UpLoadIO {

    public static final String ip = "localhost";
    public static final int port = 10088;
    /**
     * 简单实现java的文件传送
     */

    public void uploadFile(String filePath) {
        try {
            // 创建待上传文件对象
            File file = new File(filePath);
            String fileName = file.getName();
            long fileLength = file.length();
            System.out.println("客户端待上传文件：" + fileName + "，其大小为：" + fileLength);

            // 创建FileInputStream
            FileInputStream fileInputStream = new FileInputStream(filePath);

            // 创建Socket对象
            Socket socket = new Socket(UpLoadIO.ip, UpLoadIO.port);
            // 从Socket获取OutputStream
            OutputStream outputStream = socket.getOutputStream();
            // 创建DataOutputStream
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // 利用DataOutputStream写出文件名和文件大小
            dataOutputStream.writeUTF(fileName);
            dataOutputStream.writeLong(fileLength);
            dataOutputStream.flush();

            // IO流读写操作
            byte[] buf = new byte[1024 * 1];
            int len = 0;
            while ((len = fileInputStream.read(buf)) != -1) {
                dataOutputStream.write(buf, 0, len);
            }

            // 释放资源
            dataOutputStream.flush();
            fileInputStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void downloadFile() {
        try {
            // 创建Socket对象
            Socket socket = new Socket(UpLoadIO.ip, UpLoadIO.port);
            // 从Socket获取InputStream
            InputStream inputStream = socket.getInputStream();
            // 创建DataInputStream对象
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            // 获取下载文件的文件名和文件大小
            String fileName = dataInputStream.readUTF();
            long fileLength = dataInputStream.readLong();
            System.out.println("客户端下载文件：" + fileName + "，其大小为：" + fileLength);

            // 组拼文件保存路径
            String fileDir = "D:";
            String filePath = fileDir + File.separator + fileName;

            // 创建FileOutputStream对象
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);

            // IO流读写操作
            byte[] buf = new byte[1024 * 1];
            int len = 0;
            while ((len = dataInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, len);
            }

            // 释放资源
            fileOutputStream.flush();
            fileOutputStream.close();
            dataInputStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
   
}
