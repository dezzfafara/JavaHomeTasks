package task_16;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IsAscendingTests {
	private Array array;

	@BeforeClass
	public void beforeClass() {
		array = new Array();
	}

	@Test
	public void testIsAscending() {
		assertTrue(array.isAscending(new int[] { 15, 18, 46 }), "NOT ASCENDING!");
	}

	@Test
	public void testIsAscendingNotAscending() {
		assertFalse(array.isAscending(new int[] { 15, 15, 46 }), "ASCENDING!");
	}

	@AfterClass
	public void afterClass() {
		array = null;
	}
}
