package homeworkx;

import lesson21.OfficeDAO.Office;

import java.math.BigDecimal;
import java.util.Set;

public interface OfficeDAO {
        Set<Office> getAllOffices();
        Set<Office> getOfficesByRegion(String region);
        boolean insertOffice(Office office);
        boolean updateOffice(Office office);
        boolean deleteOffice(BigDecimal id);
}
