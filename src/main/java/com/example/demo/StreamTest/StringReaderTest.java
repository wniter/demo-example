package com.example.demo.StreamTest;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * @create 2021-12-31 22:06
 */
public class StringReaderTest {
    public static void main(String[] args) {
        //<init>,close,read,reset,mark,skip,markSupported,ready,isClosed,checkNotClosed

    }

    public static Properties deserialize(String serialized) throws IOException {
        StringReader reader = new StringReader(serialized);
        Properties properties = new Properties();
        properties.load(reader);
        reader.close();
        return properties;
    }

    public static String read(String content) throws Exception {
        StringReader in = new StringReader(content);
        int s;
        String sb = "";
        while ((s = in.read()) != -1) {
            sb += (char) s;
        }
        in.close();
        return sb;
    }
}

