package org.example.adapterrest.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.adapterrest.dto.RoomDTO;
import org.example.domain.entity.Room;
import org.example.domain.service.RoomService;
import org.example.infra.orm.repository.RoomEntityRepository;
import org.example.infra.orm.repository.impl.RoomRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

@Path("room")
public class RoomResource {

    private final RoomService roomService;

    public RoomResource() {
        roomService = new RoomService(new RoomRepositoryImpl(new RoomEntityRepository()));
    }

    @GET
    @Path("{search}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoomDTO> get(@PathParam("search") String search) {
        List<Room> list = roomService.searchRoom(search);
        return list
                .stream()
                .map(room -> RoomDTO.
                        builder()
                        .bgndate(room.getBgndate())
                        .enddate(room.getEnddate())
                        .name(room.getName())
                        .id(room.getId())
                        .build()).collect(Collectors.toList());
    }

    @POST
    public Response post(RoomDTO roomDTO) {
        try {
            roomService.createRoom(roomDTO.getName(), roomDTO.getBgndate(), roomDTO.getEnddate());
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            roomService.deleteRoom(id);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }
}
