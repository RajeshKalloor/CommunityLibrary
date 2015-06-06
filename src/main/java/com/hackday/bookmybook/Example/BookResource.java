package com.hackday.bookmybook.Example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackday.internal.impl.BookOperations;
import com.hackday.structures.BookDetails;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by rajesh.kalloor on 06/06/15.
 */
@Path("/book")
public class BookResource {

    //API to add a new book
    //@Path("/book")
//    public void createBook(String body) throws IOException {
//
//    }

    //API to search for a book tag
//    @POST
//    public Response

    //API to add a new book

    @GET
    public void checking() throws IOException {
        System.out.println("checkkk ::: ");
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBook(BookDetails body) throws IOException,SQLException {
//        ObjectMapper mapper = new ObjectMapper();
//        BookDetails book = mapper.readValue(body, BookDetails.class);

        System.out.println("body is ::: " +body);
        new BookOperations().addBookToDB(body);
        System.out.println("afftteerrr ::: ");

    }
}
