package task_15;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class InitArrayTests {

	private static final int ARRAY_DEFAULT_SIZE = 5;
	private static final String BEFORE_MESSAGE = "BEFORE INIT ARRAY ";
	private static final String AFTER_MESSAGE = "AFTER INIT ARRAY ";
	private static final String CLASS_MESSAGE = "CLASS";

	@BeforeClass
	public static void beforeInitArrayClass() {
		System.out.println(BEFORE_MESSAGE + CLASS_MESSAGE);
	}

	@Before
	public void before() {
		System.out.println(BEFORE_MESSAGE);
	}

	@Test
	public void testInitArrayNotNull() {
		Array actualArray = new Array();
		assertNotNull("NULL REFERENCE!", actualArray.initArray(ARRAY_DEFAULT_SIZE));
	}

	@Test
	public void testInitArrayEqual() {
		Array actualArray = new Array();
		int[] expecteArray = { 1, 2, 3, 4, 5 };
		assertArrayEquals("ARRAYS ARE NOT EQUAL!", expecteArray, actualArray.initArray(ARRAY_DEFAULT_SIZE));
	}

	@Test(expected = NegativeArraySizeException.class)
	public void testInitArrayNegativeArraySize() {
		Array actualArray = new Array();
		actualArray.initArray(-10);
	}

	@Ignore("JUST TO IGNORE...")
	public void testFailTest() {
		fail();
	}

	@After
	public void after() {
		System.out.println(AFTER_MESSAGE);
	}

	@AfterClass
	public static void afterInitArrayClass() {
		System.out.println(AFTER_MESSAGE + CLASS_MESSAGE);
	}
}
