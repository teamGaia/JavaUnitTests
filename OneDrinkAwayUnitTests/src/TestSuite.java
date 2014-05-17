import static org.junit.Assert.*;
import modelTest.TestDrinkModel;
import modelTest.TestMLModel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


import org.junit.Test;

import commonTest.DrinkInfoTest;
import commonTest.DrinkTest;
import dbTest.DrinkDataTest;
import dbTest.DrinkDbTest;

@RunWith(Suite.class)
@SuiteClasses({
	DrinkInfoTest.class,
	DrinkTest.class,
	DrinkDataTest.class, 
	DrinkDbTest.class,
	TestDrinkModel.class, 
	TestMLModel.class
})
public class TestSuite {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
