package task_16;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InitArrayTests {

	private Array array;
	private int[] actualArray;

	@BeforeClass
	public void initObject() {
		array = new Array();
	}

	@Test
	public void testFailTest() {
		fail();
	}

	@Test
	public void testInitArrayNotNull() {
		actualArray = array.initArray(new int[] { 11, 33, 22, 55 });
		assertNotNull(actualArray, "NULL!");
	}

	@Test
	public void testInitArrayEqual() {
		int[] expectedArray = { 11, 33, 55, 22 };
		actualArray = array.initArray(new int[] { 11, 33, 55, 22 });
		assertEquals(actualArray, expectedArray, "ARRAYS ARE NOT EQUAL!");
	}

	@AfterClass
	public void clearObject() {
		array = null;
	}
}
