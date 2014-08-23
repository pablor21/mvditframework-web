/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdit.framework.web.ws;

import com.mvdit.framework.core.utils.JsonListDeserializer;
import com.mvdit.framework.data.QueryCondition;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Pablo Ramírez
 */
public class CustomQueryConditionListDeserializer extends JsonListDeserializer<QueryCondition> {

    @Override
    public List<QueryCondition> deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        List<QueryCondition>items = jp.readValueAs(new TypeReference<List<QueryCondition>>() {});
        return items;
        /*ObjectMapper mapper = new ObjectMapper();
        String str= jp.readValueAs(new TypeReference<String>() {});
        TypeFactory typeFactory = mapper.getTypeFactory();
        MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, QueryCondition.class);
        HashMap<String, QueryCondition> map = mapper.readValue(str, mapType);
        return map;*/
    }
}
