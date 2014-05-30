import modelTest.TestDrinkModel;
import modelTest.TestMLModel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import commonTest.DrinkInfoTest;
import commonTest.DrinkTest;

import dbTest.DrinkDbTest;

@RunWith(Suite.class)
@SuiteClasses({
	DrinkInfoTest.class,
	DrinkTest.class,
	DrinkDbTest.class,
	TestDrinkModel.class, 
	TestMLModel.class
})
public class TestSuite { }
