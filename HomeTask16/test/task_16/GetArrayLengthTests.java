package task_16;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetArrayLengthTests {
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
	public void testGetArrayLength() {
		int expectedValue = 2;
		assertEquals(array.getArrayLength(), expectedValue, "INCORRECT LENGTH!");
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
