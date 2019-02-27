package lesson21;

public class main {
    public static void main(String[] args) {
//        OrderDAOImpl odao = new OrderDAOImpl();
        ProductsDAO pdao = new ProductsDAO();

        //System.out.println(odao.findOrderById(new BigDecimal(112968)).getProduct());
        Products p = pdao.findBroductsById("2A45C");
        System.out.println(p);
        p.getOrders().forEach(System.out::println);
    }
}
