package dbTest;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.onedrinkaway.db.DrinkData;
import com.onedrinkaway.db.DrinkDb;
import com.onedrinkaway.model.Drink;

public class DrinkDbTest {

	private Drink drink;

    @Before
    public void setUp() throws Exception {
        // we aren't in android, so DrinkDb needs a little help getting ready:
        try {
            Scanner sc = new Scanner(new File("pwd.txt"));
            String password = sc.next();
            DrinkData dd = DrinkData.getDrinkDataDB(password);
            DrinkDb.setDrinkData(dd);
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	drink = DrinkDb.getAllDrinks().iterator().next();
    }

    @After
    public void tearDown() throws Exception {
    	
    }

    @Test
    public void testGetDrink() {
    	Set<Drink> arr = DrinkDb.getAllDrinks();
    	Drink first = arr.iterator().next();
    	Drink test = DrinkDb.getDrink(first.name);
    	assertTrue(first.equals(test));
    }
    
    @Test
    public void testRateOneDrink() {
        DrinkDb.addRating(drink, 2);
        assertTrue(drink.getUserRating() == 2);
        assertTrue(drink.getRating() == 2);
        Drink dcopy = DrinkDb.getDrink(drink.name);
        assertTrue(dcopy.getUserRating() == 2);
        assertTrue(dcopy.getRating() == 2);
        Set<Drink> ratedDrinks = DrinkDb.getRatedDrinks();
        assertTrue(ratedDrinks.size() == 1);
        assertTrue(ratedDrinks.contains(drink));
        assertTrue(ratedDrinks.contains(dcopy));
    }

    @Test
    public void testGetDrinkInfo(){
    	//assertTrue(DrinkDb.getDrinkInfo(drink) == null);
    }
    
    @Test
    public void testGetRatedDrinks(){
    	Drink[] arr = getXRandomDrinks(10, DrinkDb.getAllDrinks());
    	for(int i = 0; i < 10; i++){
    		DrinkDb.addRating(arr[i], 1);
    	}
    	Set<Drink> rated = DrinkDb.getRatedDrinks();
    	assertTrue(rated.size() == 10);
    	for(Drink d : rated){
    		assertTrue(d.getUserRating() == 1);
    	}
    	
    	for(Drink d : arr){
    		assertTrue(rated.contains(d));
    	}
    }
    
    @Test
    public void testGetFavorites(){
    	clearFavoritesList();
		Drink[] arr = getXRandomDrinks(10, DrinkDb.getAllDrinks());
		for(Drink d : arr){
			DrinkDb.addFavorite(d);
		}
		Set<Drink> favs = DrinkDb.getFavorites(); 
		assertTrue(favs.size() == 10);
		for(Drink d : arr){
			assertTrue(favs.contains(d));
		}
		clearFavoritesList();
    }
    
    @Test
    public void testAddFavorite(){
    	DrinkDb.addFavorite(drink);
    	assertTrue(DrinkDb.getFavorites().size() == 1);
    	assertTrue(DrinkDb.getFavorites().iterator().next().equals(drink));
    	DrinkDb.removeFavorite(drink);
    }
    
    @Test
    public void testRemoveFavorite(){
    	DrinkDb.addFavorite(drink);
    	assertTrue(DrinkDb.getFavorites().size() == 1);
    	DrinkDb.removeFavorite(drink);
    	assertTrue(DrinkDb.getFavorites().size() == 0);
    }
    
    private void clearFavoritesList(){
    	Set<Drink> favs = DrinkDb.getFavorites();
    	for(Drink d : favs){
    		DrinkDb.removeFavorite(d);
    	}
    	assertTrue(DrinkDb.getFavorites().size() == 0);
    }
    
    private Drink[] getXRandomDrinks(int x, Set<Drink> drinks){ 
    	Set<Drink> ret = new HashSet<Drink>();
    	Drink[] allDrinks = (Drink[]) drinks.toArray(new Drink[drinks.size()]);
    	Random r = new Random();
    	for(int i = 0; i < x; i++){
    		Drink d = allDrinks[r.nextInt(allDrinks.length)];
    		if(!ret.contains(d)){
    			ret.add(d);
    		} else {
    			i--;
    		}
    	}
    	return (Drink[]) ret.toArray(new Drink[x]);
    }
}
