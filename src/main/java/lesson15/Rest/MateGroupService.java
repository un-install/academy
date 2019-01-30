package lesson15.Rest;

import lesson15.Person;
;import javax.ws.rs.core.Response;

public interface MateGroupService {
    public Response getMateGroup();
    public Response addStudents(int groupId, Person person);
}
