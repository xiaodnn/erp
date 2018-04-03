package com.erp.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

//    public static final String LOG_TYPE_TRACE = "trace";
//    public static final String LOG_TYPE_DEBUG = "debug";
//    public static final String LOG_TYPE_INFO = "info";
//    public static final String LOG_TYPE_WARN = "warn";
//    public static final String LOG_TYPE_ERROR = "error";

//    public void t(String s){
//
//        logger.trace(s);
//    }
//
//    public void d(String s){
//        logger.debug(s);
//    }
//
//    public void i(String s){
//        logger.info(s);
//    }
//
//    public void w(String s){
//        logger.warn(s);
//    }
//
//    public void e(String s){
//        logger.error(s);
//    }

    /**
     * debug 日志消息
     * @param clazz
     * @param msg
     */
    public static void debug(Class clazz,String msg){
        Logger logger = LoggerFactory.getLogger(clazz);

//        /*** 获取输出信息的代码的位置 ***/
//        String location = "";
//        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
//        location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
//                + "(" + stacks[2].getLineNumber() + ")";
//        /*** 是否是异常  ***/
//        if (obj instanceof Exception) {
//            Exception e = (Exception) obj;
//            StringWriter sw = new StringWriter();
//            e.printStackTrace(new PrintWriter(sw, true));
//            String str = sw.toString();
//            log.warn(location + str);
//        } else {
//            log.warn(location + obj.toString());
//        }
//
        /*** 获取输出信息的代码的位置 ***/
        String location = "";
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
                + "(" + stacks[2].getLineNumber() + ")";

        if(null == msg) {
            msg = location;
        }else {
            msg = msg.concat(" . ").concat(location);
        }

//        if(LoggerUtil.LOG_TYPE_TRACE.equals(type)){
//            logger.trace(msg);
//        }else if(LoggerUtil.LOG_TYPE_INFO.equals(type)){
//            logger.info(msg);
//        }else if(LoggerUtil.LOG_TYPE_WARN.equals(type)){
//            logger.warn(msg);
//        }else if(LoggerUtil.LOG_TYPE_ERROR.equals(type)){
//            logger.error(msg);
//        }
        //        else if(LoggerUtil.LOG_TYPE_DEBUG.equals(type)){
        //            logger.debug(msg);
        //        }
//        else{
            logger.debug(msg);
//        }
    }

    /**
     * info 日志消息
     * @param clazz
     * @param msg
     */
    public static void info(Class clazz,String msg){
        Logger logger = LoggerFactory.getLogger(clazz);

//        /*** 获取输出信息的代码的位置 ***/
//        String location = "";
//        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
//        location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
//                + "(" + stacks[2].getLineNumber() + ")";
//        /*** 是否是异常  ***/
//        if (obj instanceof Exception) {
//            Exception e = (Exception) obj;
//            StringWriter sw = new StringWriter();
//            e.printStackTrace(new PrintWriter(sw, true));
//            String str = sw.toString();
//            log.warn(location + str);
//        } else {
//            log.warn(location + obj.toString());
//        }
//
        /*** 获取输出信息的代码的位置 ***/
        String location = "";
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
                + "(" + stacks[2].getLineNumber() + ")";

        if(null == msg) {
            msg = location;
        }else {
            msg = msg.concat(" . ").concat(location);
        }

//        if(LoggerUtil.LOG_TYPE_TRACE.equals(type)){
//            logger.trace(msg);
//        }else if(LoggerUtil.LOG_TYPE_INFO.equals(type)){
            logger.info(msg);
//        }else if(LoggerUtil.LOG_TYPE_WARN.equals(type)){
//            logger.warn(msg);
//        }else if(LoggerUtil.LOG_TYPE_ERROR.equals(type)){
//            logger.error(msg);
//        }
    //        else if(LoggerUtil.LOG_TYPE_DEBUG.equals(type)){
    //            logger.debug(msg);
    //        }
//        else{
//            logger.debug(msg);
//        }
    }

    /**
     * wran  日志消息
     * @param clazz
     * @param msg
     */
    public static void wran(Class clazz,String msg){
        Logger logger = LoggerFactory.getLogger(clazz);

//        /*** 获取输出信息的代码的位置 ***/
//        String location = "";
//        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
//        location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
//                + "(" + stacks[2].getLineNumber() + ")";
//        /*** 是否是异常  ***/
//        if (obj instanceof Exception) {
//            Exception e = (Exception) obj;
//            StringWriter sw = new StringWriter();
//            e.printStackTrace(new PrintWriter(sw, true));
//            String str = sw.toString();
//            log.warn(location + str);
//        } else {
//            log.warn(location + obj.toString());
//        }
//
        /*** 获取输出信息的代码的位置 ***/
        String location = "";
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
                + "(" + stacks[2].getLineNumber() + ")";

        if(null == msg) {
            msg = location;
        }else {
            msg = msg.concat(" . ").concat(location);
        }

//        if(LoggerUtil.LOG_TYPE_TRACE.equals(type)){
//            logger.trace(msg);
//        }else if(LoggerUtil.LOG_TYPE_INFO.equals(type)){
//            logger.info(msg);
//        }else if(LoggerUtil.LOG_TYPE_WARN.equals(type)){
            logger.warn(msg);
//        }else if(LoggerUtil.LOG_TYPE_ERROR.equals(type)){
//            logger.error(msg);
//        }
        //        else if(LoggerUtil.LOG_TYPE_DEBUG.equals(type)){
        //            logger.debug(msg);
        //        }
//        else{
//            logger.debug(msg);
//        }
    }

    /**
     * error 日志消息
     * @param clazz
     * @param msg
     */
    public static void error(Class clazz,String msg){
        Logger logger = LoggerFactory.getLogger(clazz);

//        /*** 获取输出信息的代码的位置 ***/
//        String location = "";
//        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
//        location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
//                + "(" + stacks[2].getLineNumber() + ")";
//        /*** 是否是异常  ***/
//        if (obj instanceof Exception) {
//            Exception e = (Exception) obj;
//            StringWriter sw = new StringWriter();
//            e.printStackTrace(new PrintWriter(sw, true));
//            String str = sw.toString();
//            log.warn(location + str);
//        } else {
//            log.warn(location + obj.toString());
//        }
//
            /*** 获取输出信息的代码的位置 ***/
            String location = "";
            StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
            location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
                    + "(" + stacks[2].getLineNumber() + ")";

            if(null == msg) {
                msg = location;
            }else {
                msg = msg.concat(" . ").concat(location);
            }
//
//        if(LoggerUtil.LOG_TYPE_TRACE.equals(type)){
//            logger.trace(msg);
//        }else if(LoggerUtil.LOG_TYPE_INFO.equals(type)){
//            logger.info(msg);
//        }else if(LoggerUtil.LOG_TYPE_WARN.equals(type)){
//            logger.warn(msg);
//        }else if(LoggerUtil.LOG_TYPE_ERROR.equals(type)){
        logger.error(msg);
//        }
//        else if(LoggerUtil.LOG_TYPE_DEBUG.equals(type)){
//            logger.debug(msg);
//        }
//        else{
//            logger.debug(msg);
//        }
    }

    /**
     * error 日志消息
     * @param clazz
     * @param msg
     * @param e
     */
    public static void error(Class clazz,String msg,Exception e){
        Logger logger = LoggerFactory.getLogger(clazz);

//        /*** 获取输出信息的代码的位置 ***/
//        String location = "";
//        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
//        location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
//                + "(" + stacks[2].getLineNumber() + ")";
//        /*** 是否是异常  ***/
//        if (obj instanceof Exception) {
//            Exception e = (Exception) obj;
//            StringWriter sw = new StringWriter();
//            e.printStackTrace(new PrintWriter(sw, true));
//            String str = sw.toString();
//            log.warn(location + str);
//        } else {
//            log.warn(location + obj.toString());
//        }
//
        if( e instanceof Exception ){
            /*** 获取输出信息的代码的位置 ***/
            String location = "";
            StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
            location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
                    + "(" + stacks[2].getLineNumber() + ")";
            /*** 是否是异常  ***/
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw, true));
            String error = sw.toString();
            if(null == msg) {
                msg = location;
            }else {
                msg = msg.concat(" . ").concat(location);
            }
        }
//
//        if(LoggerUtil.LOG_TYPE_TRACE.equals(type)){
//            logger.trace(msg);
//        }else if(LoggerUtil.LOG_TYPE_INFO.equals(type)){
//            logger.info(msg);
//        }else if(LoggerUtil.LOG_TYPE_WARN.equals(type)){
//            logger.warn(msg);
//        }else if(LoggerUtil.LOG_TYPE_ERROR.equals(type)){
        logger.error(msg,e);
//        }
//        else if(LoggerUtil.LOG_TYPE_DEBUG.equals(type)){
//            logger.debug(msg);
//        }
//        else{
//            logger.debug(msg);
//        }
    }
}
