package commonTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.onedrinkaway.model.Drink;

/**
 * Test cases for Drink class in OneDrinkAway project
 * 
 * @author John L. Wilson
 *
 */

public class DrinkTest {
	
    public DrinkTest() {
    	
    }
    
    public Drink d;
    @Before
    public void setUp() throws Exception {
    	d = new Drink("name", 1, 1, new int[1], new ArrayList<String>(), "glass");
    }

    @After
    public void tearDown() throws Exception {
    	d = null;
    }
    
    @Test
    public void testGetUserRateAndAddUserRateAreSame() {
    	d.addUserRating(1);
    	assertTrue(d.getUserRating() == 1);
    	
    	d.addUserRating(2);
    	assertFalse(d.getUserRating() == 1);
    	assertTrue(d.getUserRating() == 2);
    	
    	d.addUserRating(3);
    	assertFalse(d.getUserRating() == 2);
    	assertTrue(d.getUserRating() == 3);
    	
    	d.addUserRating(4);
    	assertFalse(d.getUserRating() == 3);
    	assertTrue(d.getUserRating() == 4);
    	
    	d.addUserRating(5);
    	assertFalse(d.getUserRating() == 4);
    	assertTrue(d.getUserRating() == 5);
    }

    /**
     * Basic Constructor Test
     */
    @Test
    public void testDrinkConstructor() {
        assertTrue(d != null);
        assertTrue(d.name.equals("name"));
        assertTrue(d.id == 1);
        assertTrue(d.glass.equals("glass"));
        assertTrue(d.getUserRating() == -1);
    }
}
