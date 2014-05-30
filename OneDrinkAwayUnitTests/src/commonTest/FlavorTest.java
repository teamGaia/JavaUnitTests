package commonTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.onedrinkaway.model.Drink;
import com.onedrinkaway.model.Flavor;


/**
 * This class tests the implementation of the Flavor class
 * @author nicolekihara
 *
 */
public class FlavorTest {

	@Test
	public void testEqualsTwoEqualFlavors() {
		String sweet1 = "Sweet";
		String sweet2 = "Sweet";
		Flavor f1 = new Flavor(sweet1, 5);
		Flavor f2 = new Flavor(sweet2, 5);
		assertTrue("Two flavors with the same name and sweetness should be equal", f1.equals(f2));
	}
	
	@Test
	public void testEqualsSymmetry() {
		String sweet1 = "Sweet";
		String sweet2 = "Sweet";
		Flavor f1 = new Flavor(sweet1, 5);
		Flavor f2 = new Flavor(sweet2, 5);
		assertTrue("Failed symmetry", f2.equals(f1));
	}
	
	@Test
	public void testEqualsTwoEqualFlavorsWithDifferentRanks() {
		String sweet1 = "Sweet";
		String sweet2 = "Sweet";
		Flavor f1 = new Flavor(sweet1, 4);
		Flavor f2 = new Flavor(sweet2, 5);
		assertTrue("Two flavors with the same name but different rank should be equal", f1.equals(f2));
	}
	
	@Test
	public void testEqualsTwoDifferentFlavors() {
		String sweet = "Sweet";
		String bitter = "Bitter";
		Flavor f1 = new Flavor(sweet, 5);
		Flavor f2 = new Flavor(bitter, 5);
		assertFalse("Two flavors with different names should not be equal", f1.equals(f2));
	}
	
	@Test
	public void testEqualsTwoDifferentObjects() {
		String sweet = "Sweet";
		Flavor f1 = new Flavor(sweet, 5);
		Drink d = new Drink("name", 1, 1, new int[1], new ArrayList<String>(), "glass", "image");
		assertFalse("A Flavor should not equal a drink object", f1.equals(d));
		assertFalse("A drink object should not equal a Flavor", d.equals(f1));
	}
	
	@Test
	public void testEqualsNull() {
		String sweet = "Sweet";
		Flavor f1 = new Flavor(sweet, 5);
		assertFalse("A non-null flavor should not equal null", f1.equals(null));
	}
	
	@Test
	public void testHashCodeTwoEqualFlavors() {
		String sweet1 = "Sweet";
		String sweet2 = "Sweet";
		Flavor f1 = new Flavor(sweet1, 5);
		Flavor f2 = new Flavor(sweet2, 5);
		int hash1 = f1.hashCode();
		int hash2 = f2.hashCode();
		assertEquals("Teh hashcode for two equal flavors should be the same", hash1, hash2);
	}
	
	@Test
	public void testHashCodeTwoDifferentFlavorsWithSameName() {
		String sweet1 = "Sweet";
		String sweet2 = "Sweet";
		Flavor f1 = new Flavor(sweet1, 4);
		Flavor f2 = new Flavor(sweet2, 5);
		int hash1 = f1.hashCode();
		int hash2 = f2.hashCode();
		assertTrue("The hashcode for two equal flavors should be the same", hash1 != hash2);
	}

}
