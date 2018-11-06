package task_16;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

import org.testng.annotations.AfterClass;

public class GetArrayTests {
	private Array array;
	private int[] actualArray;

	@BeforeClass
	public void beforeClass() {
		array = new Array();
	}

	@BeforeMethod
	public void beforeMethod() {
		actualArray = array.initArray(new int[] { 45, -16 });
	}

	@Test
	public void testGetArrayNotNull() {
		assertSame(array.getArray(), actualArray, "DIFFERENT REFERENCES!");
	}

	@Test
	public void testGetArrayEqual() {
		assertEquals(array.getArray(), actualArray, "ARRAYS ARE NOT EQUAL!");
	}

	@Test
	public void testGetArraySameReference() {
		assertSame(array.getArray(), actualArray, "DIFFERENT REFERENCES!");
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
