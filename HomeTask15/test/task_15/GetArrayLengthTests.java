package task_15;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetArrayLengthTests {

	private static final int ARRAY_DEFAULT_SIZE = 5;
	private Array array;

	@Before
	public void initArray() {
		array = new Array();
		array.initArray(ARRAY_DEFAULT_SIZE);
	}

	@Test
	public void testGetArrayLength() {
		assertThat("INCORRECT LENGTH!", ARRAY_DEFAULT_SIZE, is(array.getArrayLength()));
	}

	@After
	public void clearArray() {
		array.clearArray();
		array = null;
	}
}
