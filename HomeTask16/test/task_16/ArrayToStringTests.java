package task_16;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArrayToStringTests {
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
	public void testArrayToStringIsStringNotNull() {
		String actualString = array.arrayToString();
		assertNotNull(actualString, "NULL STRING!");
	}

	@Test
	public void testArrayToStringIsString() {
		String actualString = array.arrayToString();
		assertEquals(actualString.getClass(), String.class, "NOT A STRING TYPE!");
	}

	@Test
	public void testArrayToStringEqual() {
		String actualString = array.arrayToString();
		String expectedString = "[45, -16]";
		assertEquals(actualString, expectedString, "STRINGS ARE NOT EQUAL!");
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
