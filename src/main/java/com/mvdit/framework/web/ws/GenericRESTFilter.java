/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdit.framework.web.ws;

import com.mvdit.framework.data.GenericFilter;
import com.mvdit.framework.data.QueryCondition;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 *
 * @author Pablo Ramírez
 */
@XmlRootElement
public class GenericRESTFilter extends GenericFilter{

    @Override
    @JsonDeserialize(using= CustomQueryConditionListDeserializer.class)
    public void setConditions(List conditions) {
        super.setConditions(conditions); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @JsonSerialize(using= CustomQueryConditionListSerializer.class)
    public List<QueryCondition> getConditions() {
        return super.getConditions(); //To change body of generated methods, choose Tools | Templates.
    } 

}
