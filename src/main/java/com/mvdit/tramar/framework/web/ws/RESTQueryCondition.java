/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdit.tramar.framework.web.ws;

import com.mvdit.framework.core.MvditUtils;
import com.mvdit.framework.data.QueryCondition;
import com.mvdit.framework.data.QueryConditionComparators;
import com.mvdit.framework.data.QueryConditionOperators;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Pablo Ramírez
 */
@XmlRootElement
public class RESTQueryCondition {

    private QueryCondition queryCondition;
/*s
    public RESTQueryCondition(String comparator, String operator, String field, String value) {         
        queryCondition= new QueryCondition(QueryConditionComparators.valueOf(comparator), QueryConditionOperators.valueOf(operator), field, value);
    }

    public RESTQueryCondition() {
        this(QueryConditionComparators.EQ.toString(), QueryConditionOperators.AND.toString(), "", "");
    }*/

    @JsonIgnore
    public QueryConditionComparators getComparatorEnum() {
        return queryCondition.getComparator();
    }

    @JsonIgnore
    public void setComparatorEnum(QueryConditionComparators comparatorEnum) {
        this.queryCondition.setComparator(comparatorEnum);
    }

    @JsonIgnore
    public QueryConditionOperators getOperatorEnum() {
        return this.queryCondition.getOperator();
    }

    @JsonIgnore
    public void setOperatorEnum(QueryConditionOperators operatorEnum) {
        this.queryCondition.setOperator(operatorEnum);
    }

    public String getField() {
        return this.queryCondition.getField();
    }

    public void setField(String field) {
        this.queryCondition.setField(field);
    }

    public String getValue() {
        return this.queryCondition.getSingleValue().toString();
    }

    public void setValue(String value) {
        this.queryCondition.setSingleValue(value);
    }
    
     public String getComparator() {
        return this.queryCondition.getComparator().toString();
    }

    public void setComparator(String comparator) {
        
        this.queryCondition.setComparator(QueryConditionComparators.EQ);
    }

    public String getOperator() {
        return this.queryCondition.getOperator().toString();
    }

    public void setOperator(String operator) {
        QueryConditionOperators operatorEnum=(!MvditUtils.stringEmpty(operator))?QueryConditionOperators.valueOf(operator.toUpperCase()):QueryConditionOperators.AND;
        this.queryCondition.setOperator(operatorEnum);
    }

    @JsonIgnore
    public boolean isValid() {
        return this.queryCondition.isValid();
    }

    @Override
    public String toString() {
        return this.queryCondition.toString();

    }

    public String toStringNotOperator() {
        return this.queryCondition.toStringNotOperator();
    }

    @JsonIgnore
    public QueryCondition getQueryCondition() {
        return queryCondition;
    }

    
}
