package lesson19;

import lesson17.OJDBCUtils;
import lesson17.models.Offices;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import static lesson19.template.OfficesLambdaDao.*;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfficesLabdaDaoTest {
    private final Offices INSERT_OFFICE = new Offices(new BigDecimal(1233), "Salt Lake", "Восток",
            new BigDecimal(104), null, new BigDecimal(2222));
    private final Offices UPDATE_OFFICE = new Offices(new BigDecimal(1233), "Miami", "Восток",
            new BigDecimal(103), null, new BigDecimal(1111));

    private static EmbeddedDatabase db;

    @BeforeClass
    public static void setUp() {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:embeded-db-init/create-db.sql")
                .build();
    }

    @Test
    public void test1InsertOffice() throws SQLException {
        assertTrue(insertOffice(INSERT_OFFICE, db.getConnection()));
    }

    @Test
    public void test2UpdateOffice() throws SQLException {
        assertTrue(updateOffice(UPDATE_OFFICE, db.getConnection()));
    }

    @Test
    public void test3DeleteOffice() throws SQLException {
        assertTrue(deleteOffice(INSERT_OFFICE, db.getConnection()));
    }

    @AfterClass
    public static void after(){
        db.shutdown();
    }
}
