package hw12;

import org.eclipse.persistence.jaxb.MarshallerProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class MainClazzToJsonJAXB {
    public static void main(String[] args) {
        try {
            System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");

            JAXBContext jaxbContext = JAXBContext.newInstance(MateGroup.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

            StringWriter sw = new StringWriter();
            marshaller.marshal(MateGroup.mateGroupExampleCreator(), sw);
            System.out.println(sw);

        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
