package dbTest;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.onedrinkaway.common.Drink;
import com.onedrinkaway.db.*;

public class DrinkDbTest {

	DrinkDb db = new DrinkDb();
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
