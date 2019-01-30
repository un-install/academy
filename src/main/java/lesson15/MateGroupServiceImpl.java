package lesson15;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "lesson15.MateGroupService")
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
}
