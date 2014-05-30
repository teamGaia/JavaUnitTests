package modelTest;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.onedrinkaway.db.DrinkData;
import com.onedrinkaway.db.DrinkDb;
import com.onedrinkaway.model.Drink;
import com.onedrinkaway.model.machinelearning.KNearestNeighborModel;

public class TestMLModel {
    
    @Before
    public void setUp() throws Exception {
     // we aren't in android, so DrinkDb needs a little help getting ready:
        try {
            DrinkData dd = DrinkData.getDrinkDataDB("test");
            DrinkDb.setDrinkData(dd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Test(timeout=3000)
	public void testRunningTime() throws IOException {
		runModel();
	}
	
	@Test
	public void testAccuracy() throws IOException {
		double acc = runModel();
		System.out.println("acc = "+(acc));
		assertTrue(runModel() >= 0.85);
	}
	
	private static double runModel() throws IOException {
		BufferedReader brTrain = new BufferedReader(new FileReader("train.csv"));
		String line;
		List<Drink> trainingSet = new LinkedList<Drink>();
		while ((line = brTrain.readLine()) != null) {
		   Drink curDrink = buildDrink(line);
		   trainingSet.add(curDrink);
		}
		KNearestNeighborModel model = new KNearestNeighborModel(5); 
		model.train(trainingSet);
		brTrain.close();
		
		BufferedReader brTest = new BufferedReader(new FileReader("test.csv"));
		line = null;
		int allCount = 0;
		int rightCount = 0;
		while((line = brTest.readLine()) != null) {
			Drink curDrink = buildDrink(line);
			if(curDrink == null) {
				System.out.println("curDrink is null");
			}
			double res = model.predictRating(curDrink);
			
			if((res < 0 && curDrink.getAvgRating() < 0) ||
				(res >= 0 && curDrink.getAvgRating() >= 0)) {
				rightCount++;
			}
			allCount++;
		}
		brTest.close();
		return ((double) rightCount/allCount);
	}
	
	private static Drink buildDrink(String line) {
		line = line.trim();
		   String[] info = line.split(",");
		   int[] attributes = new int[info.length-1];
		   for(int i = 1; i < info.length; i++) {
				attributes[i-1] = Integer.parseInt(info[i]);
		   }
		   return new Drink("aaa", 1, Double.parseDouble(info[0]), attributes, new LinkedList<String>(), "aaa", "aaa");
	}

}
