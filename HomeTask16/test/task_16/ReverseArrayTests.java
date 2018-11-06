package task_16;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReverseArrayTests {
	private Array array;
	private int[] actualArray;

	@BeforeClass
	public void beforeClass() {
		array = new Array();
	}

	@BeforeMethod
	public void beforeMethod() {
		actualArray = array.initArray(new int[] { 45, -33, 10, 0 });
	}

	@Test
	public void testReverseArrayNotNull() {
		assertNotNull(actualArray, "NULL REFERENCE!");
	}

	@Test
	public void testReverseArrayEqual() {
		int[] expectedArray = { 0, 10, -33, 45 };
		actualArray = array.reverseArray(actualArray);
		assertEquals(actualArray, expectedArray, "ARRAYS ARE NOT EQUAL!");
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testReverseArrayNullPointerException() {
		int[] testArray = null;
		array.reverseArray(testArray);
	}

	@AfterMethod
	public void afterMethod() {
		array.clearArray();
	}

	@AfterClass
	public void afterClass() {
		array = null;
	}
}
