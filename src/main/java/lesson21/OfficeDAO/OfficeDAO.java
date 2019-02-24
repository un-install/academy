package lesson21.OfficeDAO;

import lesson17.models.Offices;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public interface OfficeDAO {
        Set<Office> getAllOffices() throws SQLException;
        Set<Office> getOfficesByRegion(String region) throws SQLException;
        boolean insertOffice(Office office) throws SQLException;
        boolean updateOffice(Office office) throws SQLException;
        boolean deleteOffice(BigDecimal id) throws SQLException;
}
