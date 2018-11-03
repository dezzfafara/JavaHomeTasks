package task_15;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoesContainTests {

	private static final int ARRAY_DEFAULT_SIZE = 5;
	private Array array;

	@Before
	public void initArray() {
		array = new Array();
		array.initArray(ARRAY_DEFAULT_SIZE);
	}

	@Test
	public void testDoesContainContains() {
		assertTrue("DOESN'T CONTAIN!", array.doesContainElement(3));
	}

	@Test
	public void testDoesContainDoesNotContain() {
		assertFalse("CONTAINS!", array.doesContainElement(11));
	}

	@After
	public void clearArray() {
		array.clearArray();
		array = null;
	}
}
