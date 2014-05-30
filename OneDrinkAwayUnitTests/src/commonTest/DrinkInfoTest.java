package commonTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.onedrinkaway.model.DrinkInfo;

public class DrinkInfoTest {
	
	public DrinkInfo di;

    @Before
    public void setUp() throws Exception {
    	List<String> l = new LinkedList<String>();
    	l.add("a");
    	di = new DrinkInfo(l, "garnish", "instructions", 1);
    }

    @After
    public void tearDown() throws Exception {
    	di = null;
    }
    
    @Test
    public void testFields() {
        testDrinkInfo(di);
    }
    
    @Test
    public void testIngredientsCannotAdd() {
    	boolean canAdd = true;
    	try {
    		di.ingredients.add("a");
    	} catch(Exception e) {
    		canAdd = false;
    	}
    	assertFalse(canAdd);
    }
    
    @Test
    public void testIngredientsCannotRemove() {
    	boolean canRemove = true;
    	try {
    		di.ingredients.remove(0);
    	} catch(Exception e) {
    		canRemove = false;
    	}
    	assertFalse(canRemove);
    }
    
    @Test
    public void testIngredientsCannotClear() {
    	boolean canClear = true;
    	try {
    		di.ingredients.remove(0);
    	} catch(Exception e) {
    		canClear = false;
    	}
    	assertFalse(canClear);
    }
    
    /**
     * Tests all fields on DrinkInfo for completeness
     */
    public static void testDrinkInfo(DrinkInfo di) {
        assertTrue(di != null);
        assertTrue(di.drinkId > 0);
        assertTrue(di.garnish.length() > 0);
        assertTrue(di.ingredients.size() > 0);
        assertTrue(di.instructions.length() > 0);
        for (String ingr : di.ingredients) {
            assertTrue(ingr.length() > 0);
        }
    }
}
