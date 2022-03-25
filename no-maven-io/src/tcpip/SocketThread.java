package com.example.springboot.tcpip;

import java.net.Socket;

public class SocketThread implements Runnable{
    private Socket socket;
    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //        socket.getInputStream();
    }
}
