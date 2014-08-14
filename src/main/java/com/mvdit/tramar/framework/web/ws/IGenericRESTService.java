/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvdit.tramar.framework.web.ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Pablo Ramírez
 * @param <T>
 * @param <K>
 * @param <R> Tipo de resultados
 */
public interface IGenericRESTService<T, K, R extends GenericRESTResponse, F extends GenericRESTFilter> {
    /**
     * Crea un nuevo elemento
     * @return El elemento creado
     */
    R getNew();
    
    /**
     * Crea un nuevo elemento
     * @param entity
     * @return El elemento creado
     */
    R create(T entity);

    /**
     * Actualiza un elemento
     * @param entity
     * @return El elemento modificado
     */
    R update(T entity);

    /**
     * Elimina un elemento
     * @param id
     * @return 
     */
    R delete(K id);

    /**
     * Lista elementos
     * @param uriInfo
     * @return 
     */
    R list(@Context UriInfo uriInfo);
    
    /**
     * Lista elementos
     * @return 
     */
    R listAll();

    /**
     * Busca un elemento por id
     * @param id
     * @return 
     */
    R getById(K id);
}
