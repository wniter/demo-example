package com.example.demo.StreamTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @create 2021-12-31 22:07
 */
public class OutputStreamWriterTest {
    public static void main(String[] args) throws Exception {
        //<init>,write,flush,close,append,getEncoding,convert,drainEncoder,flushBytes,checkStatus
        String urlParameters = "param1=a&param2=b&param3=c";
        URL url = new URL("http://example.com/index.php");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write(urlParameters);
        //刷新流。
        writer.flush();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));


        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        writer.close();
        reader.close();
    }
}
