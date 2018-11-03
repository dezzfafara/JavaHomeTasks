package task_15;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetElementByIndexTests {

	private static final int ARRAY_DEFAULT_SIZE = 5;
	private Array array;

	@Before
	public void initArray() {
		array = new Array();
		array.initArray(ARRAY_DEFAULT_SIZE);
	}

	@Test
	public void testGetElementByIndex() {
		int expectedValue = 4;
		assertEquals("NO SUCH ELEMENT!", expectedValue, array.getElementByIndex(3));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetElementByIndexOutOfBoundsException() {
		array.getElementByIndex(11);
	}

	@After
	public void clearArray() {
		array.clearArray();
		array = null;
	}
}
