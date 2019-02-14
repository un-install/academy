package lesson17;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        OrderDAOImpl dao = new OrderDAOImpl();
        BigDecimal id = new BigDecimal(113042);
        System.out.println(dao.findOrderById(id));
        System.out.println();

        dao.getAllOrdersJoin().forEach(System.out::println);
        System.out.println();
        dao.getAllOrders().forEach(System.out::println);
        System.out.println();

        OfficeDAOImpl odao = new OfficeDAOImpl();
        odao.getAllOffices().forEach(System.out::println);
        System.out.println();
        odao.getOfficesByRegion("Запад").forEach(System.out::println);

    }
}