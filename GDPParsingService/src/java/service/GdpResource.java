/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import client.GDPParser;
import com.google.gson.Gson;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author starw
 */
@Path("gdp")
public class GdpResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GdpResource
     */
    public GdpResource() {
    }
    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();

    /**
     * Retrieves representation of an instance of service.GdpResource
     * @param asyncResponse
     * @param country
     * @return an instance of java.lang.String
     */
    @Path("/{country}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getJson(@Suspended
    final AsyncResponse asyncResponse, @PathParam(value = "country")
    final String country) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doGetJson(country));
            }
        });
    }

    private String doGetJson(@PathParam("country") String country) {
        Gson gson = new Gson();
        GDPParser parser = new GDPParser();
        parser.parseCountryGDP("http://api.worldbank.org/v2/countries/"+country+"/indicators/NY.GDP.MKTP.CD?format=json");

        String jsongdp = gson.toJson(parser.getYearlyGDPsJSON());
        
        return jsongdp;
    }


}
