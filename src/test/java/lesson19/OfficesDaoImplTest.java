package lesson19;

import lesson17.models.Offices;
import lesson19.template.OfficesDaoImpl.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfficesDaoImplTest {
    private final Offices INSERT_OFFICE = new Offices(new BigDecimal(1233), "Salt Lake", "Восток",
            new BigDecimal(104), null, new BigDecimal(2222));
    private final Offices UPDATE_OFFICE = new Offices(new BigDecimal(1233), "Miami", "Восток",
            new BigDecimal(103), null, new BigDecimal(1111));

    @Test
    public void test1InsertOffice() throws SQLException {
        OfficeInsert ofi = new OfficeInsert();
        assertTrue(ofi.template(INSERT_OFFICE));
    }

    @Test
    public void test2UpdateOffice() throws SQLException {
        OfficeUpdate ori = new OfficeUpdate();
        assertTrue(ori.template(UPDATE_OFFICE));
    }

    @Test
    public void test3DeleteOffice() throws SQLException {
        OfficeDelete ori = new OfficeDelete();
        assertTrue(ori.template(INSERT_OFFICE));
    }
}
