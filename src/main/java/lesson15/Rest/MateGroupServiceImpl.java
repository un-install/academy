package lesson15.Rest;

import jdk.net.SocketFlow;
import lesson15.MateGroup;
import lesson15.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

@Path("/rs/mate")
public class MateGroupServiceImpl implements MateGroupService {
    private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMateGroup() {
        return Response.status(Response.Status.OK).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    @PUT
    @Path("/{groupId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudents(@PathParam("groupId") int groupId, Person person) {
        if (groupId == mateGroup.getId()) {
            mateGroup.getStudents().addAll(Arrays.asList(person));
            return Response.status(Response.Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
