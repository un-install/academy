package lesson17;

import lesson17.models.Offices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OfficeDAOImpl implements OfficeDAO {
    @Override
    public Set<Offices> getAllOffices() throws SQLException {
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from offices");
        ResultSet rs = stmt.executeQuery();

        Set<Offices> offices = new HashSet<>();
        while (rs.next()){
            offices.add(OJDBCUtils.newOfficeByRs(rs));
        }
        return offices;
    }

    @Override
    public Set<Offices> getOfficesByRegion(String region) throws SQLException {
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from offices where region = ?");
        stmt.setString(1, region);
        ResultSet rs = stmt.executeQuery();

        Set<Offices> offices = new HashSet<>();
        while (rs.next()){
            offices.add(OJDBCUtils.newOfficeByRs(rs));
        }
        return offices;
    }
}
