/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdit.tramar.framework.web.ws;

import com.mvdit.framework.data.GenericFilter;
import com.mvdit.framework.data.GenericPageResult;
import com.mvdit.framework.data.IFilter;
import com.mvdit.framework.data.IPageResult;
import com.mvdit.framework.services.IGenericCRUDService;
import java.lang.reflect.ParameterizedType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Pablo Ramírez
 * @param <T>
 * @param <K>
 * @param <F>
 * @param <R>
 */
public abstract class GenericRESTService<T, K, R extends GenericRESTResponse, F extends GenericRESTFilter> implements IGenericRESTService<T, K, R, F> {

    @Context
    protected UriInfo uriInfo;
    @Context
    protected Request request;
    protected Class<T> entityClass;
    protected Class<R> resultClass;
    protected Class<F> filterClass;

    public GenericRESTService() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.resultClass = (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
        this.filterClass= (Class<F>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[3];;
    }
    
    protected F getFilterFromString(String source){
        F restFilter= (F) GenericRESTConverter.fromString(source, filterClass);
        return restFilter;
    }
    
    protected T getObjectFromRequest(String source){
        T obj= (T) GenericRESTConverter.fromString(source, entityClass);
        return obj;
    }

    protected abstract IGenericCRUDService<T, K> getServiceInstance();

    protected abstract R getResponseInstance();   

    /**
     * El genero del elemento
     *
     * @return
     */
    protected abstract String getMensajeSingular();

    /**
     *
     * @return
     */
    protected abstract String getMensajePlural();

    @GET
    @Path("new")
    @Override
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public R getNew() {
        R response = getResponseInstance();
        try {
            T newEntity = this.entityClass.newInstance();
            if (newEntity == null) {
                throw new Exception("No ha sido posible crear " + this.getMensajeSingular());
            }
            response.setResponseCode(200);
            response.setType(RESTResultType.SINGLE);
            response.setSingleResult(newEntity);
        } catch (Exception ex) {
            response.setResponseCode(500);
            response.setMessage(ex.getMessage());
        }
        return response;
    }

    @POST
    @Path("new")
    @Override
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public R create(String source) {
        R response = getResponseInstance();
        try {
            T sourceEntity= this.getObjectFromRequest(source);
            T newEntity = getServiceInstance().create(sourceEntity);
            if (newEntity == null) {
                throw new Exception("No ha sido posible crear " + this.getMensajeSingular());
            }
            response.setResponseCode(200);
            response.setType(RESTResultType.SINGLE);
            response.setSingleResult(newEntity);
            response.setMessage("Se ha creado correctamente " + this.getMensajeSingular());
        } catch (Exception ex) {
            response.setResponseCode(500);
            response.setMessage(ex.getMessage());
        }
        return response;
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public R update(String source) {
        R response = getResponseInstance();
        try {
            T sourceEntity= this.getObjectFromRequest(source);
            T newEntity = getServiceInstance().update(sourceEntity);
            if (newEntity == null) {
                throw new Exception("No ha sido posible modificar " + this.getMensajeSingular());
            }
            response.setResponseCode(200);
            response.setType(RESTResultType.SINGLE);
            response.setSingleResult(newEntity);
            response.setMessage("Se ha modificado correctamente " + this.getMensajeSingular());
        } catch (Exception ex) {
            response.setResponseCode(500);
            response.setMessage(ex.getMessage());
        }
        return response;
    }

    @DELETE
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    @Override
    public R delete(@PathParam("id") K id) {
        R response = getResponseInstance();
        try {
            T entity= getServiceInstance().getById(id);
            int cantidad = getServiceInstance().delete(entity);
            if (cantidad == 0) {
                throw new Exception("No ha sido posible eliminar " + this.getMensajeSingular());
            }
            response.setResponseCode(200);
            response.setType(RESTResultType.SINGLE);
            //response.setSingleResult(1);
            response.setMessage("Se han eliminado correctamente " + cantidad + " " + this.getMensajePlural());
        } catch (Exception ex) {
            response.setResponseCode(500);
            response.setMessage(ex.getMessage());
        }
        return response;
    }

    /*@GET
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    @Override
    public GenericRESTResponse list(@Context UriInfo uriInfo) {
        GenericRESTResponse response = getResponseInstance();
        try {
            GenericRESTFilter filter = (GenericRESTFilter) GenericRESTConverter.fromString(uriInfo.getQueryParameters().getFirst("filter"), GenericRESTFilter.class);
            IPageResult elements = getServiceInstance().list(filter);
            response.setResponseCode(200);
            response.setType(RESTResultType.MULTIPLE);
            response.setResultList((GenericPageResult) elements);
        } catch (Exception ex) {
            response.setResponseCode(500);
            response.setMessage(ex.getMessage());
        }
        return response;
    }*/
    
    @GET
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    @Override
    public R list(@Context UriInfo uriInfo) {
        R response = getResponseInstance();
        try {
            IPageResult elements = getServiceInstance().list(this.getFilterFromString(uriInfo.getQueryParameters().getFirst("filter")));
            response.setResponseCode(200);
            response.setType(RESTResultType.MULTIPLE);
            response.setResultList((GenericPageResult) elements);
        } catch (Exception ex) {
            response.setResponseCode(500);
            response.setMessage(ex.getMessage());
        }
        return response;
    }

    @GET
    @Path("all")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    @Override
    public R listAll() {
       R response = getResponseInstance();
        try {
            //RESTGenericFilterWrapper filter = RESTGenericFilterWrapper.fromString(uriInfo.getQueryParameters().getFirst("filter"));
            IPageResult elements = getServiceInstance().list(new GenericFilter(1, 0));
            response.setResponseCode(200);
            response.setType(RESTResultType.MULTIPLE);
            response.setResultList((GenericPageResult) elements);
        } catch (Exception ex) {
            response.setResponseCode(500);
            response.setMessage(ex.getMessage());
        }
        return response;
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    @Override
    public R getById(@PathParam("id") K id) {
        T entity = getServiceInstance().getById(id);
        R response = this.getResponseInstance();
        response.setType(RESTResultType.SINGLE);
        response.setResponseCode(200);
        response.setSingleResult(entity);

        if (entity == null) {
            response.setResponseCode(404);
            response.setMessage("No se ha encontrado el elemento con id:" + id);
        }
        return response;
    }

}
