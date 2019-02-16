package lesson17;

import lesson17.models.Offices;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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

    @Test
    public void testInsertOffice() throws SQLException {
        assertTrue(odao.insertOffice(new Offices(new BigDecimal(1233), "Salt Lake", "Восток",
                new BigDecimal(104), null, new BigDecimal(2222))));
    }

    @Test
    public void testUpdateOffice() throws SQLException {
        assertTrue(odao.updateOffice(new Offices(new BigDecimal(1233), "Miami", "Восток",
                new BigDecimal(103), null, new BigDecimal(1111))));
    }

    @Test
    public void testDeleteOffice() throws SQLException {
        assertTrue(odao.deleteOffice(new BigDecimal(1233)));
    }
}
