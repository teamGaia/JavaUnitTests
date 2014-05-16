package commonTest;
import static org.junit.Assert.*;

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
    public void testAddUserRating() {
    	d.addUserRating(1);
    	assertTrue(d.getRating() == 1);
    	
    	d.addUserRating(2);
    	assertFalse(d.getRating() == 1);
    	assertTrue(d.getRating() == 2);
    	
    	d.addUserRating(3);
    	assertFalse(d.getRating() == 2);
    	assertTrue(d.getRating() == 3);
    	
    	d.addUserRating(4);
    	assertFalse(d.getRating() == 3);
    	assertTrue(d.getRating() == 4);
    	
    	d.addUserRating(5);
    	assertFalse(d.getRating() == 4);
    	assertTrue(d.getRating() == 5);
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
    
    @Test
    public void testGetAvgRating() {
    	
    }
    
    

	@Test
	public void testGetRateAndSetRateAreSame() {
		
	}

	@Test
	public void testGetAttributesReturnValue() {
		
	}
	//</test Drink>
    
    
    
    
}
