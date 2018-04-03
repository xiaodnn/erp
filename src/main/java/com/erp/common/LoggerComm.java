package com.erp.common;

import com.erp.utils.LoggerUtil;

public class LoggerComm {

    /**
     * debug 日志消息
     * @param clazz
     * @param msg
     */
    public static void LoggerDebug(Class clazz ,String msg){
        LoggerUtil.debug(clazz,msg);
    }

    /**
     * info 日志消息
     * @param clazz
     * @param msg
     */
    public static void loggerInfo(Class clazz ,String msg){
        LoggerUtil.info(clazz,msg);
    }

    /**
     * 日志消息
     * @param clazz
     * @param msg
     */
    public static void loggerWran(Class clazz ,String msg){
        LoggerUtil.wran(clazz,msg);
    }

    /**
     * 打印日志
     * @param clazz 类
     * @param msg 日志消息
     */
    public static void loggerError(Class clazz ,String msg){
        LoggerUtil.error(clazz,msg);
    }

    /**
     * 打印日志
     * @param clazz 类
     * @param msg 日志消息
     * @param e 异常类
     */
    public static void loggerError(Class clazz ,String msg,Exception e){
        LoggerUtil.error(clazz,msg,e);
    }
}
