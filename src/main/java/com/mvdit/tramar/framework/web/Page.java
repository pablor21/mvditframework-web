/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvdit.tramar.framework.web;

import com.mvdit.framework.core.MvditUtils;
import com.mvdit.framework.core.PropertiesRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo Ramírez
 */
public class Page {
    private HttpServletResponse response;
    private HttpServletRequest request;
    private String viewFileName;
    private PropertiesRepository props;
    private String requestPath;

    public Page(HttpServletRequest request, HttpServletResponse response) {
        this.response = response;
        this.request = request;
        props= PropertiesRepository.getInstance();
    }   
    

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
    

    public String getViewFileName() {
        return viewFileName;
    }

    public void setViewFileName(String viewFileName) {
        this.viewFileName = (!MvditUtils.stringEmpty(viewFileName))?viewFileName:"index";
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }
    
    
    
    public void includeView() throws ServletException, IOException{
        String path=props.getProperty("mvdit.viewsPath");
        String suffix= props.getProperty("mvdit.viewsSuffix");
        request.getRequestDispatcher(path + viewFileName + suffix).include(request, response);
    }
    
    public void includeController() throws ServletException, IOException{
        request.getRequestDispatcher("/controllers/" + requestPath).include(request, response);
    }
    
    public void printPage() throws ServletException, IOException{
        this.includeController();
        this.includeView();
    }
    
}
