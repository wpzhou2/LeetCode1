package Search;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * BinarySearch Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÎåÔÂ 18, 2019</pre>
 */
public class BinarySearchTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: binarySearch(int arr[], int target)
     */
    @Test
    public void testBinarySearch() throws Exception {
        //TODO: Test goes here...
        int[] arr = {1, 3, 5, 7, 9, 11, 32};
        int location = BinarySearch.binarySearch(arr, 32);
        System.out.println(location);
    }


}
