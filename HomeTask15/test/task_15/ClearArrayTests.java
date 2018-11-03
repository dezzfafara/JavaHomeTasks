package task_15;

import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClearArrayTests {

	private static final int ARRAY_DEFAULT_SIZE = 5;
	private Array array;
	private int[] myArray;

	@Before
	public void initArray() {
		array = new Array();
		myArray = array.initArray(ARRAY_DEFAULT_SIZE);
	}

	@Test
	public void testClearArray() {
		myArray = array.clearArray();
		assertNull("NOT NULL !", myArray);
	}

	@After
	public void clearArray() {
		array.clearArray();
		array = null;
	}
}
