package hw12;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class MainJsonToClazzJAXB {
    public static void main(String[] args) {
        try {
            System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");
            JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
            unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);

            MateGroup mg = (MateGroup) unmarshaller.unmarshal(new File("src/main/resources/hw12/mateGroup.json"));
            System.out.println(mg);
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
