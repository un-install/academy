package lesson16.rest;

import lesson16.rest.MateGroup.MateGroup;
import lesson16.rest.MateGroup.Person;
import lesson16.rest.MateGroup.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


/**
 * @author spasko
 */
@Path("/rs/mate/{groupId}")
public class MateGroupServiceImpl implements MateGroupService {
	private static Map<Integer, MateGroup> mateGroups = Arrays.asList(MateGroup.mateGroupExampleCreator()).stream()
			.collect(Collectors.toMap(MateGroup::getId, Function.identity()));

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMateGroup(@PathParam("groupId") int groupId) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			return Response.status(Status.OK).entity(mateGroups.get(groupId)).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@PUT
	@Path("/students")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStudents(@PathParam("groupId") int groupId, Person person) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			mateGroup.getStudents().addAll(Arrays.asList(person));
			return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@DELETE
	@Path("/students/{surname}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStudent(@PathParam("groupId") int groupId,@PathParam("surname") String surname) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null && mateGroup.getStudents().stream().anyMatch(f -> f.getSurname().equals(surname))) {
			mateGroup.setStudents(mateGroup.getStudents().stream().filter(f -> !f.getSurname().equals(surname)).collect(Collectors.toList()));
			mateGroups.put(groupId, mateGroup);
			return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@PUT
	@Path("/students/update/{surname}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStudent(@PathParam("groupId") int groupId,@PathParam("surname") String surname, @QueryParam("name") String name) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			List<Person> students = mateGroup.getStudents().stream().map(f ->
			{
				if(f.getSurname().equals(surname))
					f.setName(name);
				return f;
			}
			).collect(Collectors.toList());
			mateGroup.setStudents(students);
			return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
}
