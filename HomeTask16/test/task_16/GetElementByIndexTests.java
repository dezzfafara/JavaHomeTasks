package task_16;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetElementByIndexTests {
	private Array array;

	@BeforeClass
	public void beforeClass() {
		array = new Array();
	}

	@BeforeMethod
	public void beforeMethod() {
		array.initArray(new int[] { 45, -16 });
	}

	@Test
	public void testGetElementByIndex() {
		int expectedValue = -16;
		assertEquals(array.getElementByIndex(1), expectedValue, "INCORRECT ELEMENT!");
	}

	@Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
	public void testGetElementByIndexOutOfBoundsException() {
		array.getElementByIndex(11);
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
