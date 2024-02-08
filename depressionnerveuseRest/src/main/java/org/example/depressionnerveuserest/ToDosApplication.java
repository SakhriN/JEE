package org.example.depressionnerveuserest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/todos-world")
public class ToDosApplication {
        @GET
        @Produces("text/plain")
        public String todos() {
            return "Liste des courses!";
        }

}
