/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvdit.tramar.framework.web.ws;

import com.mvdit.framework.core.MvditRuntimeException;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Pablo Ramírez
 */
public class GenericRESTConverter {
    /**
     * Convierte (parsea) un string al objeto deseado
     * @param jsonRepresentation
     * @param ObjClass
     * @return 
     */
    public static Object fromString(String jsonRepresentation, Class<?> ObjClass) {
        ObjectMapper mapper = new ObjectMapper();
        Object wrapper = null;
        try {
            wrapper = mapper.readValue(jsonRepresentation, ObjClass);
        } catch (IOException e) {
            throw new MvditRuntimeException(e);
        }
        return wrapper;
    }
}
