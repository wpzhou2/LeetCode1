package Sort;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * InsertSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 17, 2019</pre>
 */
public class InsertSortTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: insertSort(int[] arr)
     */
    @Test
    public void testInsertSort() throws Exception {
        //TODO: Test goes here...
        int[] arr = {3, 2, 6, 4, 9, 1, 20, 7, 222, 0};
        int[] sort = InsertSort.insertSort(arr);
        for (int i : sort) {
            System.out.print(i + "\t");
        }
    }


}
