package task_16;

import static org.testng.Assert.assertNull;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClearArrayTests {
	private Array array;
	private int[] actualArray;

	@BeforeClass
	public void initObject() {
		array = new Array();
	}

	@BeforeMethod
	public void initArray() {
		actualArray = array.initArray(new int[] { 0, 15, -33 });
	}

	@Test
	public void testClearArray() {
		actualArray = array.clearArray();
		assertNull(actualArray, "NOT NULL!");
	}

	@AfterMethod
	public void clearArray() {
		array.clearArray();
	}

	@AfterClass
	public void clearObject() {
		array = null;
	}
}
