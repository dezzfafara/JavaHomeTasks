package task_16;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShellSortArrayTests {
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
	public void testShellSortArrayNotNull() {
		actualArray = array.shellSortArray();
		assertNotNull(actualArray, "NULL ARRAY!");
	}

	@Test
	public void testShellSortArrayEqual() {
		actualArray = array.shellSortArray();
		int[] expectedArray = { -33, 0, 10, 45 };
		assertEquals(actualArray, expectedArray, "ARRAYS ARE NOT EQUAL!");
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
