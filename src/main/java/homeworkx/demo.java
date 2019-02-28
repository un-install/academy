package homeworkx;

import homeworkx.DAO.EntityDAOImpl;
import homeworkx.models.*;

import java.math.BigDecimal;

//there was some issues with toString in models
//so it gets primary key of related entities instead itself

public class demo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        EntityDAOImpl<Order> odao = new EntityDAOImpl<>(Order.class);
        EntityDAOImpl<Products> pdao = new EntityDAOImpl<>(Products.class);
        EntityDAOImpl<Salesrep> sdao = new EntityDAOImpl<>(Salesrep.class);
        EntityDAOImpl<Office> ofdao = new EntityDAOImpl<>(Office.class);
        EntityDAOImpl<Customer> cdao = new EntityDAOImpl<>(Customer.class);

        odao.findEntityById(new BigDecimal(113048)).getCust().getOrders().forEach(f -> System.out.println(f));
        pdao.findEntityById("2A45C").getOrders().forEach(f -> System.out.println(f.getCust().getCustRep()));
        sdao.findEntityById(new BigDecimal(108)).getRepOffice().getEmployees().forEach(System.out::println);
        System.out.println(cdao.findEntityById(new BigDecimal(2111)).getCustRep().getManager().getManager().getManager());

    }
}
