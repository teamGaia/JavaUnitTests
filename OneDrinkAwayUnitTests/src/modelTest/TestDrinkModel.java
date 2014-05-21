package modelTest;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.onedrinkaway.db.DrinkData;
import com.onedrinkaway.db.DrinkDb;
import com.onedrinkaway.model.Drink;
import com.onedrinkaway.model.DrinkInfo;
import com.onedrinkaway.model.DrinkModel;
import com.onedrinkaway.model.Query;

public class TestDrinkModel {
	private static Drink testDrink;
    @Before
    public void setUp() throws Exception {
     // we aren't in android, so DrinkDb needs a little help getting ready:
        try {
            InputStream drinkIs = new FileInputStream(new File("drinks.tsv"));
            InputStream drinkInfoIs = new FileInputStream(new File("RecipesBeta.txt"));
            DrinkData dd = DrinkData.getDrinkData(drinkIs, drinkInfoIs);
            DrinkDb.setDrinkData(dd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    	testDrink = new Drink("testDrink", 1024, 4.5, new int[10], new ArrayList<String>(), "testGlass");
    }

    @After
    public void tearDown() throws Exception {
    	
    }

    @Test
    public void testGetAllDrinks() {
    	Drink[] arr = DrinkModel.getAllDrinks();
    	assertTrue(arr.length == DrinkDb.getAllDrinks().size());
    	assertTrue(isDrinkArraySorted(arr));
    }

    @Test
    public void testGetDrinkNames(){
    	String[] arr = DrinkModel.getDrinkNames();
    	assertTrue(arr.length == DrinkDb.getDrinkNames().size());
    	assertTrue(isStringArraySorted(arr));
    }
    
    @Test
    public void testAddRating(){
    	DrinkModel.addRating(testDrink, 1);
    	assertTrue(testDrink.getUserRating() == 1);
    }
    
    @Test
    public void testFindTrySomethingNew(){
    	DrinkModel.findTrySomethingNewDrinks();
    	Drink[] arr = DrinkModel.getResults();
    	assertTrue(isDrinkArraySorted(arr));
    }
    
    @Test
    public void testSearchForDrinksByIngredient(){
    	String[] ingredients = DrinkModel.getIngredients();
    	for(String ingredient : ingredients){
    		Query q = new Query();
	    	q.add(ingredient);
	    	DrinkModel.searchForDrinks(q);
	    	Drink[] arr = DrinkModel.getResults();
	    	for(Drink d : arr){
	    		assertTrue(DrinkDb.getIngredients(d).contains(ingredient));
	    	}
    	}
    }
    
    @Test
    public void testSearchForDrinksByCategory(){
    	String[] categories = DrinkModel.getCategories();
    	for(String category : categories){
    		Query q = new Query();
    		q.setCategory(category);
	    	DrinkModel.searchForDrinks(q);
	    	Drink[] arr = DrinkModel.getResults();
	    	for(Drink d : arr){
	    		assertTrue(d.categories.contains(category));
	    	}
    	}
    }
    
    @Test
    public void testGetDrink(){
    	String[] drinkNames = DrinkModel.getDrinkNames();
    	for(String name : drinkNames){
    		assertTrue(DrinkModel.getDrink(name).name.equals(name));
    	}
    }
    
    @Test
    public void testGetFavorites(){
    	Drink[] arr = DrinkModel.getFavorites();
    	if(arr == null){
    		assertTrue(DrinkDb.getFavorites() == null);
    	} else {
    		assertTrue(arr.length == DrinkDb.getFavorites().size());
    		assertTrue(isDrinkArraySorted(arr));
    	}
    }
    
    @Test
    public void testGetCategories(){
    	String[] arr = DrinkModel.getCategories();
    	assertTrue(arr.length == DrinkDb.getCategories().size());
    	assertTrue(isStringArraySorted(arr));
    }
    
    @Test
    public void testGetIngredients(){
    	String[] arr = DrinkModel.getIngredients();
    	assertTrue(arr.length == DrinkDb.getIngredients().size());
    	assertTrue(isStringArraySorted(arr));
    }
    
    @Test
    public void testAddFavorite(){
    	DrinkModel.addFavorite(testDrink);
    	assertTrue(DrinkModel.getFavorites().length == 1);
    	assertTrue(DrinkModel.getFavorites()[0].equals(testDrink));
    	DrinkModel.removeFavorite(testDrink);
    }
    
    @Test
    public void testRemoveFavorite(){
    	DrinkModel.addFavorite(testDrink);
    	assertTrue(DrinkModel.getFavorites().length == 1);
    	DrinkModel.removeFavorite(testDrink);
    	assertTrue(DrinkModel.getFavorites().length == 0);
    }
    
    @Test
    public void testGetDrinkInfo(){
    	Drink[] allDrinks = DrinkModel.getAllDrinks();
    	Random r = new Random();
    	for(int i = 0; i < 10; i++){
	    	Drink d = allDrinks[r.nextInt(allDrinks.length)];
	    	DrinkInfo di = DrinkModel.getDrinkInfo(d);
	    	assertTrue(di.equals(DrinkDb.getDrinkInfo(d)));
    	}
    }
    
    /**
     * Checks to see if the Drink array is sorted
     * @param arr the array to check
     * @return true if the array is sorted, false otherwise
     */
    private boolean isDrinkArraySorted(Drink[] arr){
    	Drink[] arr2 = new Drink[arr.length];
    	System.arraycopy(arr, 0, arr2, 0, arr.length);
    	Arrays.sort(arr); 
    	boolean flag = true;
    	for(int i = 0; i < arr.length; i++){
    		if(arr[i] != arr2[i]){
    			flag = false;
    		}
    	}
    	return flag;
    }
    
    /**
     * Checks to see if the String array is sorted
     * @param arr the array to check
     * @return true if the array is sorted, false otherwise
     */
    private boolean isStringArraySorted(String[] arr){
    	String[] arr2 = new String[arr.length];
    	System.arraycopy(arr, 0, arr2, 0, arr.length);
    	Arrays.sort(arr); 
    	boolean flag = true;
    	for(int i = 0; i < arr.length; i++){
    		if(arr[i].equals(arr2[i])){
    			flag = false;
    		}
    	}
    	return flag;
    }
}
