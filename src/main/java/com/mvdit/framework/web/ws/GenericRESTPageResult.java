/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvdit.framework.web.ws;

import com.mvdit.framework.data.GenericPageResult;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo Ramírez
 * @param <T>
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GenericRESTPageResult<T> extends GenericPageResult<T>{
    
}
