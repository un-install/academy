package lesson17;

import lesson17.models.Orders;

import java.math.BigDecimal;
import java.sql.Date;
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

        System.out.println(dao.insertOrder(new Orders(new BigDecimal(1111111112),
                new Date(2019, 12, 2),new BigDecimal(2102), new BigDecimal(101), "asd", null, null, null)));

        OfficeDAOImpl odao = new OfficeDAOImpl();
        odao.getAllOffices().forEach(System.out::println);
        System.out.println();
        odao.getOfficesByRegion("Запад").forEach(System.out::println);

    }
}