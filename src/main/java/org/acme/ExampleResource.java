package org.acme;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @GET()
    public Response hello() {
        ResponseHello response = new ResponseHello("Hello Approvals");

        Jsonb create = JsonbBuilder.create();
        String json = create.toJson(response);

        try {
            create.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.status(Status.OK).entity(json).build();
    }

    @GET()
    @Path("/object")
    public Response object() {
        ResponseHello response = new ResponseHello("Hello Approvals");

        return Response.status(Status.OK).entity(response).build();
    }

}