package com.example.demo.URLTest;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @create 2021-12-31 0:58
 */
public class URLTest {

    private final String serviceUrl;

    public URLTest(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public static void main(String[] args) throws Exception {
        //<init>,openStream,openConnection,toString,getPath,toURI,getProtocol,getFile,toExternalForm,getHost,getPort,
        //getQuery,equals,getRef,getUserInfo,getAuthority,hashCode,getDefaultPort,getContent

        URL yahoo = new URL("http://www.yahoo.com/");
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
    //
    public boolean hasLicensesXml() {
        try {
            //通过在指定的上下文中解析给定的规范来创建URL。
            new URL("WEB-INF/licenses.xml").openStream().close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

//获取此{@code URL}的路径部分。
    public boolean isValid(URL url) {
        return new File(url.getPath()).exists();
    }
    public String getBatcherName() {
        String batcherName;
        try {
            //获取host
            batcherName = new URL(serviceUrl).getHost();
        } catch (MalformedURLException e1) {
            batcherName = serviceUrl;
        }
        return "target_" + batcherName;
    }
}
