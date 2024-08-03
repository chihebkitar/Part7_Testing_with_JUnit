package junit;

import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ListTests {
   // private List<String> strings = Arrays.asList("this","is","a","list","of","strings");
    // the attribute us re-instantiated before each test
    // and also we can use @before
    private List<String> strings;

    @BeforeClass // this will run only once  // method needs to be static // used to init the full system
    public static void initialization(){
        System.out.println("initialization code executed only once");
    }


    @Before // this will run before each test
    public void setUp(){
        System.out.println("inside setup");
        strings = Arrays.asList("this","is","a","list","of","strings");
    }


    @Test
    public void defaultListHasCorrectSize() {
        assertEquals(6, strings.size(), "The list should have six strings");
    }

    // here we are using junit 5 has new features and implementations than junit4
    // assert that is deprecated
    // so we used asserTrue
    @Test
    public void defaultListHasSixStrings() {
        assertTrue(strings.size() == 6, "The list should contain exactly six strings");
    }

    @After // this will run after each test
    public void cleanUp(){
        System.out.println("Cleaning up ...");
    }

    @AfterClass //  this will run only once // method needs to be static
    public static void finish(){
        System.out.println("Cleaning up after all tests");
    }
}
