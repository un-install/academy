package lesson21.OfficeDAO;

import lesson17.models.Offices;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public interface OfficeDAO {
        Set<Office> getAllOffices();
        Set<Office> getOfficesByRegion(String region);
        boolean insertOffice(Office office);
        boolean updateOffice(Office office);
        boolean deleteOffice(BigDecimal id);
}
