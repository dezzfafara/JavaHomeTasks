package task_15;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = { InitArrayTests.class, ClearArrayTests.class, GetArrayTests.class, GetElementByIndexTests.class,
		GetArrayLengthTests.class, DoesContainTests.class, ArrayToStringTests.class })
public class TestRunner {

}
