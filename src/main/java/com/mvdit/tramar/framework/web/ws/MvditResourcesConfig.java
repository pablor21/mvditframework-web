/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdit.tramar.framework.web.ws;

import com.sun.jersey.api.core.PackagesResourceConfig;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Pablo Ramírez
 */
public class MvditResourcesConfig extends PackagesResourceConfig {

    @Override
    public Map<String, MediaType> getMediaTypeMappings() {
        Map<String, MediaType> map = new HashMap<>();
        map.put("xml", MediaType.APPLICATION_XML_TYPE);
        map.put("json", MediaType.APPLICATION_JSON_TYPE);
        return map;
    }
}
