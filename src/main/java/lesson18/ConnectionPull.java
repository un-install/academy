package lesson18;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lesson17.OJDBCUtils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPull {
    public static ComboPooledDataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
        cpds.setUser("MA_STUDENT");
        cpds.setPassword("KOLOBOK");

        cpds.setInitialPoolSize(5);
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(100);

        return cpds;
    }

    public static void main(String[] args) throws PropertyVetoException, SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ComboPooledDataSource data = ConnectionPull.getDataSource();
        conn = data.getConnection();
        stmt = conn.prepareStatement("select * from products");

        System.out.println("The Connection Object is of Class: " + conn.getClass());

        rs = stmt.executeQuery();
        while (rs.next())
        {
            System.out.println(OJDBCUtils.newProductByResultSet(rs));
        }
    }

}
