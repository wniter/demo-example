package com.example.demo.LoggerTest;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @create 2021-12-29 23:50
 */
//org.slf4j.Logger
@Slf4j
public class LoggerTest {
    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    public static void main(String[] args) {
        //info,error,debug,warn,isDebugEnabled,trace,isTraceEnabled,isInfoEnabled,isWarnEnabled,isErrorEnabled,getName
        logger.debug("debug");
        logger.info("info");
        logger.error("error");
    }
//日志记录器实例是否为DEBUG级别启用?
    public void debug(Object message) {
        if (message instanceof String || log.isDebugEnabled()) {
            log.debug(String.valueOf(message));
        }
    }
}
