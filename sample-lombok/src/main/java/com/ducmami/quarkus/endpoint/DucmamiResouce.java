package com.ducmami.quarkus.endpoint;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/ducmami")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class DucmamiResouce {
    @GET
    @Path("/hello")
    public Uni<Response> get() {
        //This line error when run with quarkusPlatformVersion 2.3.0.Final
        log.info("Hello From ducmami");
        return Uni.createFrom()
                .item("Hello from Ducmami")
                .map(Response::ok)
                .map(Response.ResponseBuilder::build);
    }
}
