package org.example.adapterrest.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.adapterrest.dto.UserDTO;
import org.example.domain.entity.User;
import org.example.domain.service.UserService;
import org.example.infra.orm.repository.UserEntityRepository;
import org.example.infra.orm.repository.impl.UserRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

@Path("user")
public class UserResource {

    private final UserService userService;

    public UserResource() {
        userService = new UserService(new UserRepositoryImpl(new UserEntityRepository()));
    }

    @GET
    @Path("{search}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> get(@PathParam("search") String search) {
        List<User> list = userService.searchUser(search);
        return list
                .stream()
                .map(user -> UserDTO.
                        builder()
                        .firstname(user.getFirstname())
                        .lastname(user.getLastname())
                        .email(user.getEmail())
                        .phone_number(user.getPhone_number())
                        .id(user.getId())
                        .build()).collect(Collectors.toList());
    }

    @POST
    public Response post(UserDTO userDTO) {
        try {
            userService.createUser(userDTO.getFirstname(), userDTO.getLastname(), userDTO.getEmail(), userDTO.getPhone_number());
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            userService.deleteUser(id);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }
}

