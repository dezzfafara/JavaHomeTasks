package task_16;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DoesContainTests {
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
	public void testDoesContainContains() {
		assertTrue(array.doesContainElement(-16), "DOESN'T CONTAIN!");
	}

	@Test
	public void testDoesContainDoesNotContain() {
		assertFalse(array.doesContainElement(11), "CONTAINS!");
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
