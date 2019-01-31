package hw15.SOAP;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import lesson15.MateGroup;
import lesson15.Person;
import lesson15.Teacher;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding
public interface MateGroupService {
    @WebMethod
    public MateGroup getMateGroup();

    @WebMethod
    public MateGroup addStudents(List<Person> persons);

    @WebMethod
    public MateGroup setTeacher(Teacher teacher);
}
