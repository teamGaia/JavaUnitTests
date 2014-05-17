package dbTest;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.onedrinkaway.common.Drink;
import com.onedrinkaway.common.DrinkInfo;
import com.onedrinkaway.db.DrinkData;
import commonTest.DrinkTest;


public class DrinkDataTest {
    
    DrinkData dd;

    public DrinkDataTest() {
        
    }

    @Before
    public void setUp() throws Exception {
        try {
            InputStream drinkIs = new FileInputStream(new File("drinks.tsv"));
            InputStream drinkInfoIs = new FileInputStream(new File("RecipesBeta.txt"));
            dd = DrinkData.getDrinkData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
    	
    }
    
    /*
    @Test
    public void testDrinks() {
        Set<Drink> drinks = dd.getAllDrinks();
        for (Drink d : drinks) {
            assertTrue(d != null);
            DrinkTest.testDrinkFields(d);
        }
    }
    */
    
    @Test
    public void testDrinkInfo() {
        Set<Drink> drinks = dd.getAllDrinks();
        for (Drink d : drinks) {
            DrinkInfo di = dd.getDrinkInfo(d);
            assertTrue(di != null);
        }
    }

}
