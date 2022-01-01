package com.example.demo.LoggerTest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @create 2021-12-31 22:01
 */
//java.util.logging.Logger
public class LoggerTestone {
    //log,getLogger,info,warning,fine,isLoggable,severe,setLevel,finest,finer,addHandler,getHandlers,getName,
    public static void main(String[] args) {
        Logger.global.log(Level.parse("Log a message, with no arguments."),"test");
    }
}
