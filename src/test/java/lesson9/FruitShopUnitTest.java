package lesson9;

import org.junit.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FruitShopUnitTest {
    private FruitShop fruitShop;
    private static Fruit apple;
    private static Fruit orange;
    private static Fruit pear;
    private static Fruit strawberry;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");

        List<Vitamins> vitamins = new ArrayList<>(Arrays.asList(Vitamins.A, Vitamins.B, Vitamins.C));

        apple = new Fruit(FruitType.APPLE, 10, LocalDate.of(2018,12,15), 20, vitamins);
        orange = new Fruit(FruitType.ORANGE, 6, LocalDate.now(), 25, vitamins);
        pear = new Fruit(FruitType.PEAR, 12, LocalDate.of(2018,11,23), 30, vitamins);
        strawberry = new Fruit(FruitType.STRAWBERRY, 7, LocalDate.of(2019,1,15), 40, vitamins);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @Before
    public void beforeTest() {
        System.out.println("Before Test");

        List<Fruit> fruits = new ArrayList<>();

        fruits.add(apple);
        fruits.add(strawberry);
        fruits.add(orange);
        fruits.add(pear);

        fruitShop = new FruitShop("Shop24", fruits);
    }

    @After
    public void afterTest() {
        System.out.println("After Test");
    }

    @Test
    public void testAllFruitOfFruitType() {
        List<Fruit> actual = fruitShop.allFruitOfFruitType(FruitType.APPLE);
        List<Fruit> expected = Arrays.asList(apple);
        assertEquals(actual, expected);
    }

    @Test
    public void testCheckByExpireDate() {
        List<Fruit> actual = fruitShop.checkByExpireDate(9);
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        expected.add(pear);

        assertEquals(expected,actual);
    }

    @Test
    public void testCheckByExpireDateShouldBeNothing() {
        List<Fruit> actual = fruitShop.checkByExpireDate(90);
        assertTrue(actual.size() == 0);
    }

    @Test(expected = Exception.class)
    public void testCheckByExpireDateShouldBeException() {
        List<Fruit> actual = fruitShop.checkByExpireDate(-5);
    }

    @Test
    public void testAllFreshAndFruitTypeShouldBeNothing() {
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.APPLE, LocalDate.of(2099,1,1));
        assertTrue(actual.size() == 0);
    }

    @Test (expected = NullPointerException.class)
    public void testAllFreshAndFruitTypeShouldBeNullPointerException() {
        List<Fruit> actual = fruitShop.allFreshAndFruitType(null, LocalDate.of(2099,1,1));
    }

    @Test (expected = NullPointerException.class)
    public void testAllFreshAndFruitTypeShouldBeNullPointerException2() {
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.APPLE, null);
    }

    @Test
    public void testAllFreshAndFruitType() {
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.STRAWBERRY, LocalDate.now());
        List<Fruit> expected = Arrays.asList(strawberry);
        assertEquals(actual, expected);
    }

    @Test(expected = Exception.class)
    public void testResetPricexRealizationShouldBeException() {
        fruitShop.reSetPricexRealization(-5,10, FruitType.APPLE);
    }

    @Test(expected = Exception.class)
    public void testResetPricexRealizationShouldBeException2() {
        fruitShop.reSetPricexRealization(50,-10, FruitType.APPLE);
    }

    @Test(expected = NullPointerException.class)
    public void testResetPricexRealizationShouldBeNullPointerException() {
        fruitShop.reSetPricexRealization(5,10, null);
    }
}