package task_15;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayToStringTests {

	private static final int ARRAY_DEFAULT_SIZE = 5;
	private Array array;

	@Before
	public void initArray() {
		array = new Array();
		array.initArray(ARRAY_DEFAULT_SIZE);
	}

	@Test
	public void testArrayToStringIsString() {
		String actualString = array.arrayToString();
		assertThat("NOT STRING!", actualString, isA(String.class));
	}

	@Test
	public void testArrayToStringEqual() {
		String expectedString = "[1, 2, 3, 4, 5]";
		assertThat("STRINGS ARE NOT EQUAL!", expectedString, equalTo(array.arrayToString()));
	}

	@After
	public void clearArray() {
		array.clearArray();
		array = null;
	}
}
