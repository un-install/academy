package lesson17;

import lesson17.models.Offices;

import java.sql.SQLException;
import java.util.Set;

public interface OfficeDAO {
    Set<Offices> getAllOffices() throws SQLException;
    Set<Offices> getOfficesByRegion(String region) throws SQLException;
}
