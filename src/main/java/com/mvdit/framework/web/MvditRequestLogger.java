/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdit.framework.web;

import com.mvdit.framework.core.MvditApp;
import com.mvdit.framework.core.PropertiesRepository;
import java.io.StringWriter;
import org.apache.log4j.Logger;
import org.apache.log4j.WriterAppender;

/**
 *
 * @author Pablo Ramírez
 */
public class MvditRequestLogger {

    private Logger logger;
    private StringWriter stringWriter;

    public MvditRequestLogger() {
        init();

    }

    private final void init() {
        if (MvditApp.getInstance().isDeveloperMode()) {
            PropertiesRepository props = PropertiesRepository.getInstance();
            logger = Logger.getLogger(MvditWebContants.REQUEST_LOG_NAME);
            stringWriter = new StringWriter();
            WriterAppender writerAppender = new WriterAppender(new MvditHtmlLayout(), stringWriter);
            logger.addAppender(writerAppender);
        }
    }

    public void info(Object msg) {
        if (logger != null) {
            logger.info(msg);
        }
    }

    public void info(Object msg, Throwable tw) {
        if (logger != null) {
            logger.info(msg);
        }
    }

    public void warn(Object msg) {
        if (logger != null) {
            logger.warn(msg);
        }
    }

    public void warn(Object msg, Throwable tw) {
        if (logger != null) {
            logger.warn(msg);
        }
    }

    public void error(Object msg) {
        if (logger != null) {
            logger.error(msg);
        }
    }

    public void error(Object msg, Throwable tw) {
        if (logger != null) {
            logger.error(msg);
        }
    }
    
    public String getLoggerContent(){
        return stringWriter != null ? stringWriter.toString() : "";
    }

}
