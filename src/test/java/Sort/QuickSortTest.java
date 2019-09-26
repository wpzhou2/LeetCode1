package Sort;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * QuickSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 17, 2019</pre>
 */
public class QuickSortTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: quickSort(int arr[], int left, int right)
     */
    @Test
    public void testQuickSort() throws Exception {
        //TODO: Test goes here...
        int[] arr = {3, 2, 6, 4, 9, 1, 20, 7, 222, 0};
        int[] sort = QuickSort.quickSort(arr, 0, arr.length - 1);
        for (int i : sort) {
            System.out.print(i + "\t");
        }
    }


}
