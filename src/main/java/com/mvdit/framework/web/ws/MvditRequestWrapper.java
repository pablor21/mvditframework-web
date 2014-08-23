/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvdit.framework.web.ws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *
 * @author Pablo Ramírez
 */
public class MvditRequestWrapper extends HttpServletRequestWrapper {
    Map<String, String> headers;

    public MvditRequestWrapper(HttpServletRequest request) {
        super(request);
        headers=new HashMap<>();
        Enumeration<String> headerNames = super.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name= headerNames.nextElement();
            headers.put(name, super.getHeader(name));
        }
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
    
    @Override
    public String getHeader(String name) {
       if(this.headers.containsKey(name)){
           return this.headers.get(name);
       }
       return null;
    }
    
    @Override
    public Enumeration getHeaderNames() {
        List list= new ArrayList(this.headers.keySet());
        return Collections.enumeration(list);
    }
}
