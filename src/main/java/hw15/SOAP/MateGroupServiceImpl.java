package hw15.SOAP;

import lesson15.MateGroup;
import lesson15.MateGroupService;
import lesson15.Person;
import lesson15.Teacher;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "hw15.SOAP.MateGroupService")
public class MateGroupServiceImpl implements MateGroupService {
    private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();
    @Override
    public MateGroup getMateGroup() {
        return mateGroup;
    }

    @Override
    public MateGroup addStudents(List<Person> persons) {
      mateGroup.getStudents().addAll(persons);
      return mateGroup;
    }

    @Override
    public MateGroup setTeacher(Teacher teacher) {
        mateGroup.setTeacher(teacher);
        return mateGroup;
    }
}
