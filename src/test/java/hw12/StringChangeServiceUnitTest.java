package hw12;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StringChangeServiceUnitTest {

    @Spy
    @InjectMocks
    private StringChangerService scs;

    @Mock
    private StringLowerUpperService slus;

    @BeforeClass
    public static void beforeClass(){}

    @AfterClass
    public static void afterClass(){}

    @Before
    public void before(){}

    @After
    public void after(){}

    @Test
    //mock1
    public void addStartUpperInputLowerTest() {
        when(slus.toLower(Mockito.anyString())).thenReturn("lower");
        when(slus.toUpper(Mockito.anyString())).thenReturn("UPPER");

        String expected = "UPPERlower";
        String actual = scs.addStartUpperInputLower("some", "some");

        assertEquals(actual, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    //mock2
    public void addStartAndEndUpperShouldBeIllegalArgumentException() {
        when(slus.toUpper(Mockito.anyString())).thenReturn("UPPER");
        scs.addStartAndEndUpper("some", "some", "some");
    }

    @Test
    //mock3
    public void addStartAndEndUpperTest() {
        when(slus.toUpper(Mockito.anyString())).thenReturn("UPPER");

        String expected = "some1some3UPPER";
        String actual = scs.addStartAndEndUpper("some1", "some2", "some3");

        assertEquals(actual, expected);
    }

    @Test
    //spy1
    //failing
    public void addStartAndEndTest() {
        doReturn("some").when(scs).addStart(Mockito.anyString(), Mockito.anyString());

        String expected = "some";
        String actual = scs.addStartAndEnd("some", null, "some");

        assertEquals(expected, actual);
    }

    @Test
    //spy2
    public void addStartAndEndUpperSpyTest(){
        doReturn("some").when(scs).addStart(Mockito.anyString(), Mockito.anyString());
        when(slus.toUpper(Mockito.anyString())).thenReturn("UPPER");

        String expected = "someUPPER";
        String actual = scs.addStartAndEndUpper("some", "some", "some");

        assertEquals(expected, actual);
    }

    @Test
    //spy3
    //failing
    public void addStartAndEndTotalLowerSpyTest() {
        doReturn(null).when(scs).addStart(Mockito.anyString(), Mockito.anyString());

        String expected = "lower";
        String actual = scs.addStartAndEndTotalLower("some", "LoWer", "some1");

        assertEquals(expected, actual);
    }





}
