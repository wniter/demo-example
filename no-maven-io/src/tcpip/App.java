package com.example.springboot.tcpip;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8080);
        BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter os = new PrintWriter(socket.getOutputStream());
        BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readline = sin.readLine();
        while (!readline.equals("bye")) {
            os.println(readline);
            os.flush();
            System.out.println("receive Server msg:" + is.readLine());
            readline = sin.readLine();
        }
        os.close();
        is.close();
        socket.close();
    }
}
