package lesson16.rest;

import lesson16.rest.MateGroup.HumanResource;
import lesson16.rest.MateGroup.MateGroup;
import lesson16.rest.MateGroup.Person;
import lesson16.rest.MateGroup.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	public Response deleteStudent(@PathParam("groupId") int groupId, @PathParam("surname") String surname) {
		MateGroup mateGroup = mateGroups.get(groupId);

		if (mateGroup.getStudents().stream().anyMatch(f -> surname.equals(f.getSurname())) && mateGroup != null && surname != null) {
			mateGroup.getStudents().removeIf(f -> surname.equals(f.getSurname()));
			return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@Override
	@PUT
	@Path("/students/update/{surname}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStudent(@PathParam("groupId") int groupId,@PathParam("surname") String surname, @QueryParam("name") String name) {
		MateGroup mateGroup = mateGroups.get(groupId);

		if (mateGroup != null && surname != null && mateGroup.getStudents().stream().anyMatch(f -> surname.equals(f.getSurname()))) {
			mateGroup.setStudents(mateGroup.getStudents().stream().map(f -> {
				if(surname.equals(f.getSurname()))
					f.setName(name);
				return f;
			}).collect(Collectors.toList()));
			return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	//get all hrs
	@GET
	@Path("/hrs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHrs(@PathParam("groupId") int groupId) {
		MateGroup mateGroup = mateGroups.get(groupId);

		if (mateGroup != null){
			return Response.status(Status.ACCEPTED).entity(mateGroup.getHumanResources()).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	//get hr by id
	@GET
	@Path("/hrs/{hrId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHr(@PathParam("groupId") int groupId, @PathParam("hrId") int hrId) {
		MateGroup mateGroup = mateGroups.get(groupId);

		if (isFound(hrId, mateGroup)){
			return Response.status(Status.ACCEPTED).entity(mateGroup.getHumanResources().stream().
					filter(f -> f.getPersonId() == hrId).findAny().get()).type(MediaType.APPLICATION_JSON).build(); //why Set, why??
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	//add new hr
	@POST
	@Path("/hrs")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addHr(@PathParam("groupId") int groupId, HumanResource hr) {
		MateGroup mateGroup = mateGroups.get(groupId);
		if (mateGroup != null) {
			mateGroup.getHumanResources().addAll(Arrays.asList(hr));
			return Response.status(Status.ACCEPTED).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	//remove hr
	@DELETE
	@Path("/hrs/{hrId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteHr(@PathParam("groupId") int groupId, @PathParam("hrId") int hrId) {
		MateGroup mateGroup = mateGroups.get(groupId);

		if (isFound(hrId, mateGroup)){
			mateGroup.getHumanResources().removeIf(f -> f.getPersonId() == hrId);
			return Response.status(Status.ACCEPTED).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	//update hr. change startWorkYear via queryParam
	@PUT
	@Path("/hrs/{hrId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStartWorkYear(@PathParam("groupId") int groupId, @PathParam("hrId") int hrId, @QueryParam("start-work-year") int startWorkYear) {
		MateGroup mateGroup = mateGroups.get(groupId);

		if (isFound(hrId, mateGroup)) {
			mateGroup.getHumanResources().stream().filter(f -> f.getPersonId() == hrId).forEach(f -> f.setStartWorkYear(startWorkYear));
			return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	public boolean isFound(int personId, MateGroup mg) {
		return mg != null && mg.getHumanResources().stream().anyMatch(f -> f.getPersonId() == personId);
	}
}
