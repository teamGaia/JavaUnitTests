package dbTest;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.onedrinkaway.model.Drink;

public class DrinkDbTest {

	private Drink drink;

    @Before
    public void setUp() throws Exception {
    	int[] attr = {1, 2, 3};
    	drink = new Drink("aaa", 111111, 0.9, attr, new LinkedList<String>(), "aaa");
    }

    @After
    public void tearDown() throws Exception {
    	
    }

    @Test
    public void test() {
    	
    }

}
