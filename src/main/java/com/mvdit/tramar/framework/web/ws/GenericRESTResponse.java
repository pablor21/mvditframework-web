/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvdit.tramar.framework.web.ws;

import com.mvdit.framework.data.GenericPageResult;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo Ramírez
 * @param <T>
 */
@XmlRootElement(name = "Response")
public class GenericRESTResponse<T> {
    private int responseCode;
    private RESTResultType type;
    private String message;
    private T singleResult;
    private GenericPageResult resultList;
    
    

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public RESTResultType getType() {
        return type;
    }

    public void setType(RESTResultType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getSingleResult() {
        return singleResult;
    }

    public void setSingleResult(T singleResult) {
        this.singleResult = singleResult;
    }

    public GenericPageResult getResultList() {
        return resultList;
    }

    public void setResultList(GenericPageResult resultList) {
        this.resultList = resultList;
    }

    
    
}
