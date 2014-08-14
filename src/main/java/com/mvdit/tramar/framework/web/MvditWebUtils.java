/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdit.tramar.framework.web;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Pablo Ramírez
 */
public class MvditWebUtils {

    public static MvditRequestLogger createRequestLogger() {
        return new MvditRequestLogger();
    }
    
    
    public static MvditRequestLogger getLogger(HttpServletRequest request){
        return (MvditRequestLogger) request.getAttribute(MvditWebContants.REQUEST_LOG_NAME);
    }
    
}
