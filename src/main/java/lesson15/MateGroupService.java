package lesson15;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding
public interface MateGroupService {
    @WebMethod
    public MateGroup getMateGroup();

    @WebMethod
    public MateGroup addStudents(List<Person> persons);
}
