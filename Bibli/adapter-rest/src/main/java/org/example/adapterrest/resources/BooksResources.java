package org.example.adapterrest.resources;

import biblio.models.Books;
import biblio.repositories.BookRepositoryImpl;
import biblio.repositories.BooksEntityRepository;
import biblio.service.BooksService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.adapterrest.dto.BooksDTO;


import java.util.List;
import java.util.stream.Collectors;

@Path("book")
public class BooksResources {

    private final BooksService booksService;

    public BooksResources() {
        booksService = new BooksService(new BookRepositoryImpl(new BooksEntityRepository()));
    }

    @GET
    @Path("{search}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BooksDTO> get(@PathParam("search") String search) {
        List<Books> list = booksService.searchBooks(search);
        return list
                .stream()
                .map(books -> BooksDTO.
                        builder()
                        .name_book(books.getName_book())
                        .description_book(books.getDescription_book())
                        .id(books.getId())
                        .build()).collect(Collectors.toList());
    }

    @POST
    public Response post(BooksDTO booksDTO) {
        try {
            booksService.createBooks(booksDTO.getName_book(), booksDTO.getDescription_book());
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            booksService.deleteBooks(id);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }
}

