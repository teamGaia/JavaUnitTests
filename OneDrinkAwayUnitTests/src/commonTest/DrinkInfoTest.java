package commonTest;

import static org.junit.Assert.assertFalse;

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
    	di = new DrinkInfo(l, "description", "garnish", "instructions", "citation", 1);
    }

    @After
    public void tearDown() throws Exception {
    	di = null;
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
}
