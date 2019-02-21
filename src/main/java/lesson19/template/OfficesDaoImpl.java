package lesson19.template;

import lesson17.OfficeDAO;
import lesson17.models.Offices;
import lesson17.models.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import static lesson17.OJDBCUtils.setOfficeValuesToStatement;

public class OfficesDaoImpl implements OfficeDAO {

    @Override
    public Set<Offices> getAllOffices() throws SQLException {
        return null;
    }

    @Override
    public Set<Offices> getOfficesByRegion(String region) throws SQLException {
        return null;
    }

    @Override
    public boolean insertOffice(Offices office, Connection connection) throws SQLException {
        return new abstractDao<Offices>() {
            @Override
            public PreparedStatement updateTable(Offices office, Connection conn) throws SQLException {
                PreparedStatement stmt = conn.prepareStatement("insert into offices(OFFICE, CITY, REGION, MGR, TARGET, SALES)" +
                        " values (?, ?, ?, ?, ?, ?)");
                setOfficeValuesToStatement(office, stmt);
                return stmt;
            }
        }.template(office, connection);
    }

    @Override
    public boolean updateOffice(Offices office, Connection connection) throws SQLException {
        return new abstractDao<Offices>(){

            @Override
            public PreparedStatement updateTable(Offices office, Connection conn) throws SQLException {
                PreparedStatement stmt = conn.prepareStatement("update offices set office = ?, city = ?, " +
                        "region = ?, mgr = ?, target = ?, sales =? where office = ?");

                stmt.setBigDecimal(7, office.getOffice());
                setOfficeValuesToStatement(office, stmt);

                return stmt;
            }
        }.template(office, connection);
    }

    @Override
    public boolean deleteOffice(Offices office, Connection connection) throws SQLException {
        return new abstractDao<Offices>(){
            @Override
            public PreparedStatement updateTable(Offices office, Connection conn) throws SQLException {
                PreparedStatement stmt = conn.prepareStatement("delete from offices where office = ?");
                stmt.setBigDecimal(1, office.getOffice());

                return stmt;
            }
        }.template(office, connection);
    }
}
