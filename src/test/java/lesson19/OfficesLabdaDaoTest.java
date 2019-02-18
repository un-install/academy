package lesson19;

import lesson17.OJDBCUtils;
import lesson17.models.Offices;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;

import static lesson17.OJDBCUtils.getConnection;
import static lesson19.template.OfficesLambdaDao.*;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfficesLabdaDaoTest {
    private final Offices INSERT_OFFICE = new Offices(new BigDecimal(1233), "Salt Lake", "Восток",
            new BigDecimal(104), null, new BigDecimal(2222));
    private final Offices UPDATE_OFFICE = new Offices(new BigDecimal(1233), "Miami", "Восток",
            new BigDecimal(103), null, new BigDecimal(1111));

    @Test
    public void test1InsertOffice() throws SQLException {
        assertTrue(insertOffice(INSERT_OFFICE, getConnection()));
    }

    @Test
    public void test2UpdateOffice() throws SQLException {
        assertTrue(updateOffice(UPDATE_OFFICE, getConnection()));
    }

    @Test
    public void test3DeleteOffice() throws SQLException {
        assertTrue(deleteOffice(INSERT_OFFICE, getConnection()));
    }
}
