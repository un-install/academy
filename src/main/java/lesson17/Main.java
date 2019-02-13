package lesson17;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        OrderDAOImpl dao = new OrderDAOImpl();
        BigDecimal id = new BigDecimal(113042);
      //  System.out.println(dao.findOrderById(id));
        dao.getAllOrders2().forEach(System.out::println);
    }
}
