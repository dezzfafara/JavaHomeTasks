package task_15;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetArrayTests {

	private static final int ARRAY_DEFAULT_SIZE = 5;
	private Array array;
	private int[] actualArray;

	@Before
	public void initArray() {
		array = new Array();
		actualArray = array.initArray(ARRAY_DEFAULT_SIZE);
	}

	@Test
	public void testGetArrayNotNull() {
		assertNotNull("ARRAY IS NULL!", array.getArray());
	}

	@Test
	public void testGetArrayEqual() {
		int[] expectedArray = { 1, 2, 3, 4, 5 };
		assertArrayEquals("ARRAYS ARE NOT EQUAL!", expectedArray, array.getArray());
	}

	@Test
	public void testGetArraySameReference() {
		assertSame("DIFFERENT REFERENCES!", array.getArray(), actualArray);
	}

	@After
	public void clearArray() {
		array.clearArray();
		array = null;
	}
}
