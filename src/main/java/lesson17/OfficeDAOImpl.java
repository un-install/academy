package lesson17;

import lesson17.models.Offices;

import java.math.BigDecimal;
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
            offices.add(OJDBCUtils.newOfficeByResultSet(rs));
        }
        OJDBCUtils.closeAllCloseble(conn, stmt, rs);
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
            offices.add(OJDBCUtils.newOfficeByResultSet(rs));
        }
        OJDBCUtils.closeAllCloseble(conn, stmt, rs);
        return offices;
    }

    @Override
    public boolean insertOffice(Offices office, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean updateOffice(Offices office, Connection connection) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOffice(Offices office, Connection connection) throws SQLException {
        return false;
    }

    public boolean insertOffice(Offices office) {
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = null;
        boolean isOk = false;
        try {
            stmt =  conn.prepareStatement("insert into offices(OFFICE, CITY, REGION, MGR, TARGET, SALES)" +
                    " values (?, ?, ?, ?, ?, ?)");
            setOfficeValuesToStatement(office, stmt);

            isOk = stmt.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            OJDBCUtils.closeAllCloseble(stmt, conn);
            return isOk;
        }
    }

    private void setOfficeValuesToStatement(Offices o, PreparedStatement stmt) throws SQLException {
        stmt.setBigDecimal(1, o.getOffice());
        stmt.setString(2,o.getCity());
        stmt.setString(3, o.getRegion());
        stmt.setBigDecimal(4, o.getMgr());
        stmt.setBigDecimal(5, o.getTarget());
        stmt.setBigDecimal(6, o.getSales());
    }

    public boolean updateOffice(Offices office){
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = null;
        boolean isOk = false;
        try {
            stmt = conn.prepareStatement("update offices set office = ?, city = ?, " +
                    "region = ?, mgr = ?, target = ?, sales =? where office = ?");
            stmt.setBigDecimal(7, office.getOffice());
            setOfficeValuesToStatement(office, stmt);

            isOk = stmt.executeUpdate() > 0;
            OJDBCUtils.closeAllCloseble(stmt, conn);

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            OJDBCUtils.closeAllCloseble(stmt, conn);
            return isOk;
        }
    }

    public boolean deleteOffice(BigDecimal officeId) {
        Connection conn = OJDBCUtils.getConnection();
        PreparedStatement stmt = null;
        boolean isOk = false;
        try {
            stmt = conn.prepareStatement("delete from offices where office = ?");
            stmt.setBigDecimal(1, officeId);

            isOk = stmt.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            OJDBCUtils.closeAllCloseble(stmt, conn);
            return isOk;
        }
    }
}
