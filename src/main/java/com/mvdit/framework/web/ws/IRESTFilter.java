/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvdit.framework.web.ws;

import com.mvdit.framework.data.IFilter;

/**
 *
 * @author Pablo Ramírez
 */
public interface IRESTFilter {
    IFilter getFilter();
    void setFilter(IFilter filter);
}
