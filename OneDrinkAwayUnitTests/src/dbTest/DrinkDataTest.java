package dbTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.onedrinkaway.db.DrinkData;


public class DrinkDataTest {
    
    DrinkData dd;

    public DrinkDataTest() {
        
    }

    @Before
    public void setUp() throws Exception {
        try {
            InputStream drinkIs = new FileInputStream(new File("drinks.tsv"));
            InputStream drinkInfoIs = new FileInputStream(new File("RecipesBeta.txt"));
            dd = DrinkData.getDrinkData(drinkIs, drinkInfoIs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
    	
    }
    
    @Test
    public void testGetDrink() {
    	
    }
    
    @Test
    public void testGetDrinkInfo() {
    	
    }
    
    @Test
    public void testGetIngredients() {
    	
    }
    
    @Test
    public void testAddRating() {
    	
    }
    
    @Test
    public void testAddFavorite() {
    	
    }
    
    @Test
    public void testGetCategories() {
    	
    }
    
    @Test
    public void testGetAllDrinks() {
    	
    }
    
    @Test
    public void testGetDrinkNames() {
    	
    }
    
    @Test
    public void testGetRatedDrinks() {
    	
    }
    
    @Test
    public void testGetFavorites() {
    	
    }
    
    @Test
    public void testRemoveFavorite() {
    	
    }
    
    

}
