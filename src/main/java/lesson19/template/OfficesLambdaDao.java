package lesson19.template;

import lesson17.OJDBCUtils;
import lesson17.models.Offices;
import lesson17.models.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static lesson17.OJDBCUtils.setOfficeValuesToStatement;

public class OfficesLambdaDao {
    public static boolean insertOffice(Offices office, Connection connection) {
        System.out.println("Inserting to Offices...");
        DaoFunctionalInterface daoi = (conn) ->{
            PreparedStatement stmt = conn.prepareStatement("insert into offices(OFFICE, CITY, REGION, MGR, TARGET, SALES)" +
                    " values (?, ?, ?, ?, ?, ?)");
            setOfficeValuesToStatement(office, stmt);
            return stmt;
        };

        return daoi.template(connection);
    }

    public static boolean updateOffice(Offices office, Connection connection) {
        System.out.println("Updating Offices...");
        DaoFunctionalInterface daoi = (conn) ->{
            PreparedStatement stmt = conn.prepareStatement("update offices set office = ?, city = ?, " +
                    "region = ?, mgr = ?, target = ?, sales =? where office = ?");

            stmt.setBigDecimal(7, office.getOffice());
            setOfficeValuesToStatement(office, stmt);
            return stmt;
        };

        return daoi.template(connection);
    }

    public static boolean deleteOffice(Offices office, Connection connection) {
        System.out.println("Deleting from Offices...");
        DaoFunctionalInterface daoi = (conn) ->{
            PreparedStatement stmt = conn.prepareStatement("delete from offices where office = ?");
            stmt.setBigDecimal(1, office.getOffice());
            return stmt;
        };

        return daoi.template(connection);
    }
}
