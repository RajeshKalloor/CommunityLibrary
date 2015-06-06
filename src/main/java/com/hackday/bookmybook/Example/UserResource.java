package com.hackday.bookmybook.Example;

import com.hackday.internal.impl.UserActions;
import com.hackday.structures.LoginInDetail;
import com.hackday.structures.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;

import static com.google.common.collect.Maps.newHashMap;

/**
 * Created by rajesh.kalloor on 06/06/15.
 */
@Path(value = "/user")

public class UserResource {

    public UserResource() {}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(LoginInDetail login) {
        UserActions userActions=new UserActions();
        if(userActions.validateLogin(login)) {
            //Session session=new Session();
            System.out.println("did match");
            return Response.ok().build();
        }
        else
        {
            HashMap map = newHashMap();
            map.put("message", "did not match");
            System.out.println("did not match");
            return Response.status(Response.Status.BAD_REQUEST).entity(map).build();

        }

        }



    /*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getAllProducts() {
        return new ProductImpl().getAllProducts();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getMaxBid/{productId}")
    public Product get(@PathParam("productId") String id) {
        return new ProductImpl().getMaxBid(id);
        */
    }
