package com.hackday.bookmybook.Example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackday.internal.impl.BookOperations;
import com.hackday.structures.BookDetails;
import com.hackday.structures.Books;

import javax.validation.constraints.Null;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

    @POST
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Books searchBook(JsonNode search) throws IOException, SQLException{
        //ObjectMapper mapper = new ObjectMapper();
        String book = search.get("query").asText();

        System.out.println("BOOK IS ::: " +book);

        return new BookOperations().searchBook(book);

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

    @GET
    @Path("/{book_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getBookDetails(@PathParam("book_id") Integer book_id ) throws IOException, SQLException {
        //return new BookOperations().getBookDetails(book_id);
//        try{
//            BookDetails response = new BookOperations().getBookDetails(book_id);
//            Response.ok().entity(response).build();
//        }
//        catch (SQLException e){
//            throw new WebApplicationException(Response.Status.BAD_REQUEST);
//            //Response.Status.BAD_REQUEST
//        }
//        BookDetails response = new BookOperations().getBookDetails(book_id);

        BookDetails bookDetails = new BookOperations().getBookDetails(book_id);

        if (bookDetails.getBook_id() == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else{
            return Response.ok().status(200).entity(bookDetails).build();
        }

    }

    @POST
    @Path("/{book_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void BookABook(@PathParam("book_id") Integer book_id ) throws IOException, SQLException {
        new BookOperations().bookABook(book_id);
    }

//    @POST
//    @Path("/cancel")


}
