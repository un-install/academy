package lesson17;

import lesson17.models.Offices;
import lesson17.models.Orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public interface OfficeDAO {
    Set<Offices> getAllOffices() throws SQLException;
    Set<Offices> getOfficesByRegion(String region) throws SQLException;
    boolean insertOffice(Offices office, Connection connection) throws SQLException;
    boolean updateOffice(Offices office, Connection connection) throws SQLException;
    boolean deleteOffice(Offices office, Connection connection) throws SQLException;
}
