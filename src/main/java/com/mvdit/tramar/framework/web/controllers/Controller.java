/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvdit.tramar.framework.web.controllers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author Pablo Ramírez
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
    
    String path();
    String name();
    
}
