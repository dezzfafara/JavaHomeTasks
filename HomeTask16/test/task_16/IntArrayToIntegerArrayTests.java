package task_16;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsNoOrder;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IntArrayToIntegerArrayTests {
	private Array array;

	@DataProvider(name = "toIntegerData")
	public Object[][] createToIntegerData() {
		return new Object[][] {
				{ new Integer(-11), new Integer(0), new Integer(-5),
						new ArrayList<Integer>(Arrays.asList(-11, 0, -5)) },
				{ new Integer(11), new Integer(22), new Integer(4), new ArrayList<Integer>(Arrays.asList(11, 22, 4)) },
				{ new Integer(13), new Integer(-45), new Integer(8),
						new ArrayList<Integer>(Arrays.asList(13, -45, 8)) } };
	}

	@BeforeClass
	public void beforeClass() {
		array = new Array();
	}

	@Test
	public void testIntArrayToIntegerArrayNotNull() {
		Integer[] actualArray = array.intArrayToIntegerArray(new int[] { 10, 0, -5 });
		assertNotNull(actualArray);
	}

	@Test
	public void testIntArrayToIntegerArrayIsInteger() {
		assertEquals(array.intArrayToIntegerArray(new int[] { 10, 0, -5 }).getClass(), Integer[].class);
	}

	@Test
	public void testIntArrayToIntegerArrayEqualsNoOrder() {
		Integer[] actualArray = array.intArrayToIntegerArray(new int[] { 10, 0, -5 });
		Integer[] expectedArray = array.intArrayToIntegerArray(new int[] { 0, 10, -5 });
		assertEqualsNoOrder(actualArray, expectedArray, "CONTENT OF ARRAYS IS DIFFERENT!");
	}

	@Test(dataProvider = "toIntegerData")
	public void testIntArrayToIntegerArrayEqual(Integer a, Integer b, Integer c, ArrayList<Integer> actualArray) {
		assertEquals(actualArray.toArray(),
				array.intArrayToIntegerArray(new int[] { a.intValue(), b.intValue(), c.intValue() }),
				"ARRAYS ARE DIFFERENT!");
	}

	@AfterClass
	public void afterClass() {
		array = null;
	}
}
