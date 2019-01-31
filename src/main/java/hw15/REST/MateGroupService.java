package hw15.REST;

import lesson15.Person;
import lesson15.Teacher;

import javax.ws.rs.core.Response;

;

public interface MateGroupService {
    public Response getMateGroup();
    public Response addStudents(int groupId, Person person);
    public Response setTeacher(int groupId, Teacher teacher);
}
