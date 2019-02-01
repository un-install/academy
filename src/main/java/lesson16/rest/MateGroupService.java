package lesson16.rest;

import lesson16.rest.MateGroup.Person;

import javax.ws.rs.core.Response;


/**
 * @author spasko
 */

public interface MateGroupService {

	public Response getMateGroup(int groupId);

	public Response addStudents(int groupId, Person person);

	public Response deleteStudent(int groupId, String surname);
	public Response updateStudent(int groupId, String surname, String newname);
}