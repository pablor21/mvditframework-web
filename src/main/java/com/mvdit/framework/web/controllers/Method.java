/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvdit.framework.web.controllers;

/**
 *
 * @author Pablo Ramírez
 */
public @interface Method {
    public enum MethodType{
        GET, DELETE, PUT, POST, ALL
    }
    String path();
    MethodType[] methods() default {MethodType.ALL};
    
}
