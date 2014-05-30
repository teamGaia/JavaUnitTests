package commonTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
    
    public Drink d;
    @Before
    public void setUp() throws Exception {
        List<String> categories = new ArrayList<String>();
        categories.add("cat");
    	d = new Drink("name", 1, 1, new int[11], categories, "glass", "image");
    }

    @After
    public void tearDown() throws Exception {
    	d = null;
    }
    
    @Test
    public void testDrinkFields() {
        testDrink(d);
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
    
    public static void testDrink(Drink d) {
        assertTrue(d != null);
        assertTrue(d.glass.length() > 0);
        assertTrue(d.id > 0);
        assertTrue(d.image.length() > 0);
        assertTrue(d.predictedRating > -2);
        assertTrue(d.getRating() > 0);
        assertTrue(d.categories.size() > 0);
        assertTrue(d.attributes.length == 11);
        for (int i : d.attributes)
            assertTrue(i >= 0 && i <= 5);
        for (String c : d.categories)
            assertTrue(c.length() > 0);
    }
}
