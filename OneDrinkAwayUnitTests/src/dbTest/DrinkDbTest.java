package dbTest;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.onedrinkaway.db.DrinkData;
import com.onedrinkaway.db.DrinkDb;
import com.onedrinkaway.model.Drink;
import com.onedrinkaway.model.DrinkInfo;
import commonTest.DrinkInfoTest;
import commonTest.DrinkTest;

public class DrinkDbTest {

	private Drink drink;
	Random r = new Random();

    @Before
    public void setUp() throws Exception {
        // we aren't in android, so DrinkDb needs a little help getting ready:
        try {
            // get a random userid, unlikely that it has any ratings
            String userid = "" + r.nextInt(100000000);
            DrinkData dd = DrinkData.getDrinkDataDB(userid);
            DrinkDb.setDrinkData(dd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    	drink = DrinkDb.getAllDrinks().iterator().next();
    }

    @After
    public void tearDown() throws Exception {
    	
    }

    @Test
    public void testGetOneDrink() {
    	Set<Drink> arr = DrinkDb.getAllDrinks();
    	Drink first = arr.iterator().next();
    	Drink test = DrinkDb.getDrink(first.name);
    	assertTrue(first.equals(test));
    	DrinkTest.testDrink(drink);
    }
    
    @Test
    public void testGetAllDrinks() {
        for (Drink d : DrinkDb.getAllDrinks())
            DrinkTest.testDrink(d);
    }
    
    @Test
    public void testRateOneDrink() {
        Set<Drink> ratedDrinks = DrinkDb.getRatedDrinks();
        assertTrue(ratedDrinks.size() == 0);
        DrinkDb.addRating(drink, getRandomRating());
        ratedDrinks = DrinkDb.getRatedDrinks();
        assertTrue(ratedDrinks.size() == 1);
        assertTrue(ratedDrinks.contains(drink));
    }

    @Test
    public void testGetOneDrinkInfo() {
    	Drink d = DrinkDb.getAllDrinks().iterator().next();
    	DrinkInfoTest.testDrinkInfo(DrinkDb.getDrinkInfo(d));
    }
    
    @Test
    public void testGetAllDrinkInfo() {
        Iterator<Drink> iter = DrinkDb.getAllDrinks().iterator();
        while (iter.hasNext()) {
            drink = iter.next();
            DrinkInfo di = DrinkDb.getDrinkInfo(drink);
            DrinkInfoTest.testDrinkInfo(di);
        }
    }
    
    @Test
    public void testRateFiveDrinks() {
        Set<Drink> ratedDrinks = DrinkDb.getRatedDrinks();
        assertTrue(ratedDrinks.size() == 0);
        Iterator<Drink> iter = DrinkDb.getAllDrinks().iterator();
        for (int i = 1; i <= 5; i++)
            DrinkDb.addRating(iter.next(), getRandomRating());
        ratedDrinks = DrinkDb.getRatedDrinks();
        assertTrue(ratedDrinks.size() == 5);
        assertTrue(ratedDrinks.contains(drink));
    }
    
    @Test
    public void testAddOneFavorite() {
        assertTrue(DrinkDb.getFavorites().size() == 0);
        DrinkDb.addFavorite(drink);
        assertTrue(DrinkDb.getFavorites().size() == 1);
    }
    
    @Test
    public void testAddFavorite() {
    	DrinkDb.addFavorite(drink);
    	assertTrue(DrinkDb.getFavorites().size() == 1);
    	assertTrue(DrinkDb.getFavorites().iterator().next().equals(drink));
    	DrinkDb.removeFavorite(drink);
    }
    
    @Test
    public void testRemoveFavorite() {
    	DrinkDb.addFavorite(drink);
    	assertTrue(DrinkDb.getFavorites().size() == 1);
    	DrinkDb.removeFavorite(drink);
    	assertTrue(DrinkDb.getFavorites().size() == 0);
    }

    /**
     * Gets a random rating that is either 2, 3 or 4
     */
    private int getRandomRating() {
        return 2 + r.nextInt(3);
    }
}
