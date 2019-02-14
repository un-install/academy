package lesson17;

import lesson17.models.Offices;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Set;

import static org.junit.Assert.*;

public class OfficeDAOTest {
    private OfficeDAOImpl odao = new OfficeDAOImpl();

    @Test
    public void testGetAllOffices() throws SQLException {
        Set<Offices> actual = odao.getAllOffices();
        assertTrue(actual.size() > 0);
    }

    @Test
    public void testGetOfficesByRegion() throws SQLException {
        Set<Offices> actual = odao.getOfficesByRegion("Запад");
        assertTrue(actual.size() > 0);
    }
}
