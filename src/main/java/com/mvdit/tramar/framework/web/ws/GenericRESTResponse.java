/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvdit.tramar.framework.web.ws;

import com.mvdit.framework.data.GenericPageResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnore;

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
    private Set<ConstraintViolation> validatorExceptionsSet;
    private Map<String, String> validatorExceptions;

    public GenericRESTResponse() {
        this.validatorExceptions=null;
    }
    
    

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

    @JsonIgnore
    public Set<ConstraintViolation> getValidatorExceptionsSet(){
        return this.validatorExceptionsSet;
    }
    
    public void setValidatorExceptionsSet(Set<ConstraintViolation> violations){
        this.validatorExceptionsSet= violations;
        for(ConstraintViolation violation:violations){
            this.addValidatorException(violation.getPropertyPath().toString(), violation.getMessage());
        }
    }
    
    public Map<String, String> getValidatorExceptions(){
        return this.validatorExceptions;
    }
    
    public void setValidatorExceptions(Map<String,String> exceptions){
        this.validatorExceptions=exceptions;
        
    }
    
    public void addValidatorException(String path, String message){
        if(this.validatorExceptions==null){
            this.validatorExceptions= new HashMap<>();
        }
        this.validatorExceptions.put(path, message);
    }
}
