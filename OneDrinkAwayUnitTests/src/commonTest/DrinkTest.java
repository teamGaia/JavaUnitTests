package commonTest;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.onedrinkaway.common.Drink;

/**
 * Test cases for Drink class in OneDrinkAway project
 * 
 * @author John L. Wilson
 *
 */

public class DrinkTest {

    public DrinkTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Basic Constructor Test
     */
    @Test
    public void testDrinkConstructor() {
        Drink d = new Drink("name", 1, 1, new int[1], new ArrayList<String>(), "glass");
        assertTrue(d != null);
    }
    
    /**
     * Tests all public final fields in Drink
     */
    @Test
    public void testDrinkFields() {
        Drink d = new Drink("name", 1, 1, new int[1], new ArrayList<String>(), "glass");
        testDrinkFields(d);
    }
    
    public static void testDrinkFields(Drink d) {
        assertTrue(d.id > 0);
        assertTrue(d.name != null);
        assertTrue(d.attributes != null);
        assertTrue(d.categories != null);
        assertTrue(d.glass != null);
    }

}
