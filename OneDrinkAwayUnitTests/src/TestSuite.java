import modelTest.TestDrinkModel;
import modelTest.TestMLModel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import serverTest.ServerTest;

import commonTest.DrinkInfoTest;
import commonTest.DrinkTest;
import commonTest.FlavorTest;

import dbTest.DrinkDbTest;

@RunWith(Suite.class)
@SuiteClasses({
	DrinkInfoTest.class,
	DrinkTest.class,
	DrinkDbTest.class,
	TestDrinkModel.class, 
	TestMLModel.class,
	ServerTest.class,
	FlavorTest.class
})
public class TestSuite { }
