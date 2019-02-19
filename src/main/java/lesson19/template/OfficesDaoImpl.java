package lesson19.template;

import lesson17.models.Offices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static lesson17.OJDBCUtils.setOfficeValuesToStatement;

public class OfficesDaoImpl {

    public static class OfficeInsert extends abstractDao<Offices> {
        @Override
        public PreparedStatement updateTable(Offices office, Connection conn) throws SQLException {
            PreparedStatement stmt = conn.prepareStatement("insert into offices(OFFICE, CITY, REGION, MGR, TARGET, SALES)" +
                    " values (?, ?, ?, ?, ?, ?)");
            setOfficeValuesToStatement(office, stmt);
            return stmt;
        }
    }

    public static class OfficeUpdate extends abstractDao<Offices> {

        @Override
        public PreparedStatement updateTable(Offices office, Connection conn) throws SQLException {
            PreparedStatement stmt = conn.prepareStatement("update offices set office = ?, city = ?, " +
                    "region = ?, mgr = ?, target = ?, sales =? where office = ?");

            stmt.setBigDecimal(7, office.getOffice());
            setOfficeValuesToStatement(office, stmt);

            return stmt;
        }
    }

    public static class OfficeDelete extends abstractDao<Offices> {

        @Override
        public PreparedStatement updateTable(Offices office, Connection conn) throws SQLException {
            PreparedStatement stmt = conn.prepareStatement("delete from offices where office = ?");
            stmt.setBigDecimal(1, office.getOffice());

            return stmt;
        }
    }
}
