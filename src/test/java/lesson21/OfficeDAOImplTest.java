package lesson21;

import lesson21.OfficeDAO.Office;
import lesson21.OfficeDAO.OfficeDAOImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfficeDAOImplTest {
    private static final Office UPDATE_OFFICE = new Office(new BigDecimal(1233), "Miami", "West",
            new BigDecimal(103), null, new BigDecimal(1111));

    private OfficeDAOImpl officeDAO = new OfficeDAOImpl();

    private final Office INSERT_OFFICE = new Office(new BigDecimal(11), "Salt Lake", "East",
            new BigDecimal(104), null, new BigDecimal(2222));

    @Test
    public void test1InsertOffice(){
        assertTrue(officeDAO.insertOffice(INSERT_OFFICE));
    }

    @Test
    public void test2UpdateOffice(){
        assertTrue(officeDAO.updateOffice(UPDATE_OFFICE));
    }

    @Test
    public void test3DeleteOffice(){
        assertTrue(officeDAO.deleteOffice(new BigDecimal(22)));
    }
}
