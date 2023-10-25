
package com.tarea1.conversion.resource;

import com.tarea1.conversion.service.ConversionService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author omayen
 */

@Path("/convert")
public class ConversionResource {
    
    @Inject
    ConversionService conversionService;

    @GET
    @Path("/usdToCop")
    public Response convertUSDToCOP(@QueryParam("amount") Double amount) {
        Double result = conversionService.convertUSDToCOP(amount);
        return Response.ok(result).build();
    }
}
